package com.prodyna.dataprotection.navigator.service;

import com.atlassian.confluence.core.BodyType;
import com.atlassian.confluence.pages.Page;
import com.atlassian.confluence.pages.PageManager;
import com.atlassian.confluence.setup.settings.SettingsManager;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.prodyna.dataprotection.navigator.model.ContentModel;
import com.prodyna.dataprotection.navigator.model.MacroType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The service will differentiate between quiz and content and parse the macros.
 */
@Named
public class ContentService {

    private final PageManager pageManager;

    private final SettingsManager settingsManager;

    @Inject
    public ContentService(
            @ComponentImport SettingsManager settingsManager,
            @ComponentImport PageManager pageManager
    ) {
        this.settingsManager = settingsManager;
        this.pageManager = pageManager;
    }

    /**
     * Get the list of all contents on the given page.
     *
     * @param page the confluence page to get the contents for.
     * @return a list of the contents for the page.
     */
    private List<ContentModel> getAllContent(Page page) {
        List<ContentModel> contents = new ArrayList<>();

        // Get all the macros for the datenschutz-navigator-content and datenschutz-navigator-quiz.
        Elements macros =
                Jsoup.parse(page.getBodyContent(BodyType.XHTML).getBody())
                        .select("[ac:name^='datenschutz-navigator-']");

        String baseUrl = this.settingsManager.getGlobalSettings().getBaseUrl();
        String confluencePrefix = baseUrl.substring(baseUrl.lastIndexOf("/"));

        for (Element element : macros) {
            ContentModel content = new ContentModel(
                    element.outerHtml(),
                    page,
                    confluencePrefix,
                    this.pageManager
            );
            contents.add(content);
        }

        contents.forEach(c -> {
            if (c.getType() == MacroType.QUIZ) {
                c.setActive(true);
            }
        });
        return contents;
    }

    /**
     * Fetches the content of a page in a given language
     *
     * @param confluencePage The page to get content from
     * @param language       the Language
     * @return Returns the PageContent fitting the language
     */
    public List<ContentModel> getThisLanguageContent(Page confluencePage, String language) {

        // Get all the contents defined as macros in the page.s
        List<ContentModel> contents = getAllContent(confluencePage);

        // Filter for the correct language in the contents
        contents = contents.stream()
                .filter(c -> c.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());
        return contents;
    }
}
