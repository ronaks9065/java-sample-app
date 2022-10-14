package com.prodyna.dataprotection.navigator.model;

import com.atlassian.confluence.core.ContentEntityObject;
import com.atlassian.confluence.pages.Attachment;
import com.atlassian.confluence.pages.Page;
import com.atlassian.confluence.pages.PageManager;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The content that is parsed from the macros is inside this model.
 */
@XmlRootElement(name = "Content")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContentModel {
    private static final String MACRO_NAME = "Datenschutz-Navigator-Content";

    @JsonIgnore
    private final Element element;

    @JsonIgnore
    private final PageManager pageManager;
    private final List<Answer> answers = new ArrayList<>();
    @JsonIgnore
    private final Page page;
    private String language;
    private String name;
    private MacroType type;
    private String content;
    private String baseUrl;
    private String level;
    private Boolean active;

    public ContentModel(
            String macroContent,
            Page page,
            String baseUrl,
            PageManager pageManager
    ) {
        this.page = page;
        this.baseUrl = baseUrl;
        element = Jsoup.parse(macroContent).select("[ac:name='" + MACRO_NAME + "']").first();
        this.pageManager = pageManager;
        Elements parameters = element.getElementsByTag("ac:parameter");
        String type = this.getParameter(parameters, "Type");
        if (StringUtils.isNotEmpty(type)) {
            this.type = MacroType.valueOf(type.toUpperCase());
        }
        this.language = this.getParameter(parameters, "Language");
        this.name = this.getParameter(parameters, "Name");

        this.level = this.getParameter(parameters, "Level");
        if (this.type == MacroType.QUIZ) {
            parseQuizContent();
            parseQuizAnswers();
        } else {
            this.findContent(element);
        }
    }

    // Replaces Lombok
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MacroType getType() {
        return type;
    }

    public void setType(MacroType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * This will parse the question. The question will be returned as the content in the response.
     */
    private void parseQuizContent() {
        Elements pTags = this.element.select("p");
        this.content = pTags.size() > 0 ? pTags.get(0).text() : "";
    }

    /**
     * Parse the possible answers.
     */
    private void parseQuizAnswers() {
        Elements answerTags = this.element.getElementsByTag("ac:task");
        for (Element answerTag : answerTags) {
            Answer answer = new Answer();

            // Answers are defined as tasks in the content.
            Elements statusTag = answerTag.getElementsByTag("ac:task-status");

            // If the answer is checked in confluence. The answer should be correct.
            answer.setCorrect(statusTag.size() > 0 && statusTag.get(0).text().equals("complete"));

            Elements contentTag = answerTag.getElementsByTag("span");
            if (contentTag.size() > 0) {
                // The possible answer.
                answer.setAnswerText(contentTag.get(0).html());
            }
            answers.add(answer);
        }
    }

    /**
     * Parse the macro body and get the content.
     *
     * @param element that represents the content.
     */
    private void findContent(Element element) {
        Elements content = element.getElementsByTag("ac:rich-text-body");

        // Is there a body?
        if (content.size() > 0) {
            Element richTextBody = content.first();
            Elements imageTags = richTextBody.getElementsByTag("ac:image");
            Elements multimediaTags = richTextBody.select("[ac:name='multimedia']");

            // replace the images with real img tags and src path.
            for (Element imageTag : imageTags) {
                Element attachment = imageTag.getElementsByTag(
                        "ri:attachment").first();
                String fileName = attachment.attr("ri:fileName");
                String attachmentURL = findAttachmentUrl(fileName);
                imageTag.parent().html(String.format("<img class='' src='%s%s'/>", this.baseUrl, attachmentURL));
            }

            // replace the multimedia with video tags.
            for (Element multimediaTag : multimediaTags) {
                Elements attachments = multimediaTag.getElementsByAttribute("ri:filename");
                if (attachments.size() > 0) {
                    String fileName = attachments.get(0).attr("ri:filename");
                    String attachmentURL = findAttachmentUrl(fileName);
                    String videoTag = String.format("<video controls>\n" +
                            "  <source src=\"%s%s\" type=\"video/mp4\">\n" +
                            "  Your browser does not support the video tag.\n" +
                            "</video>", this.baseUrl, attachmentURL);
                    multimediaTag.parent().html(videoTag);
                }

            }

            this.content = richTextBody.html();
        }
    }

    /**
     * Parse the macro parameter as part of the model.
     *
     * @param parameters The elements that represent the parameter.
     * @param name       The name of the parameter.
     * @return The value of the parameter.
     */
    private String getParameter(Elements parameters, String name) {
        Elements param = parameters.select("[ac:name='" + name + "']");
        return param.size() <= 0 ? "" : (param.get(0)).html();
    }

    /**
     * Search the whole space for the attachment.
     * This makes it possible to define images that are already defined on other pages.
     *
     * @param fileName The name of the attachment. Should be unique.
     * @return the url to the img if it could be found. Empty string otherwise.
     */
    private String findAttachmentUrl(String fileName) {
        // Try to find the attachment in the space.
        Optional<Attachment> attachment = this.pageManager.getPages(this.page.getSpace(), true)
                // Get all the attachments in the space
                .stream().map(ContentEntityObject::getAttachments)
                .flatMap(List::stream)
                .filter(a -> a.getFileName().equals(fileName))
                .findFirst();

        if (attachment.isPresent()) {
            return attachment.get().getDownloadPath();
        } else {
            return "";
        }

    }
}
