package com.prodyna.dataprotection.navigator.controller;

import com.atlassian.confluence.pages.Page;
import com.atlassian.confluence.pages.PageManager;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import com.atlassian.plugin.spring.scanner.annotation.imports.ConfluenceImport;
import com.prodyna.dataprotection.navigator.model.ContentModel;
import com.prodyna.dataprotection.navigator.service.ConfigurationService;
import com.prodyna.dataprotection.navigator.service.ContentService;
import org.apache.commons.lang.StringEscapeUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

/**
 * The API for getting the contents from confluence.
 * /confluence/rest/dpn/1.0/
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/")
public class ContentController {

    private static final String WELCOME = "welcome";
    private static final String DEUTSCH = "Deutsch";

    private final PageManager pageManager;
    private final ContentService contentService;
    private final ConfigurationService configurationService;

    @Inject
    public ContentController(
            @ConfluenceImport PageManager pageManager,
            ContentService contentService,
            ConfigurationService configurationService
    ) {
        this.pageManager = pageManager;
        this.contentService = contentService;
        this.configurationService = configurationService;
    }

    /**
     * confluence/rest/dpn/1.0/content
     * This endpoint fetches the Content of a given ConfluencePage
     *
     * @param page     The page to get the contents for. Default is welcome.
     * @param language The language to get the content for. Default is Deutsch.
     * @return all contents of the provided page in the given language.
     */
    @GET
    @Path("content")
    public Response getContent(
            @DefaultValue(WELCOME) @QueryParam("page") String page,
            @DefaultValue(DEUTSCH) @QueryParam("language") String language
    ) {
        // Check if the space and the page is available.
        String spaceKey = configurationService.getConfigurationData().getDpnSpaceKey();
        Page confluencePage = this.pageManager.getPage(spaceKey, page);

        // If the page is not defined, the default content will be shown.
        if (confluencePage == null) {
            return Response.ok(new ArrayList<ContentModel>()).entity(new ArrayList<ContentModel>()).build();
        }


        return Response.ok(contentService.getThisLanguageContent
                (confluencePage, language.toLowerCase())).build();

    }


    /**
     * confluence/rest/dpn/1.0/content
     *
     * @param page The page to get the contents for. Default is welcome.
     * @return all contents of the provided page
     */
    @GET
    @Path("page")
    public Response getPage(@DefaultValue(WELCOME) @QueryParam("page") String page) {
        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        String content = VelocityUtils.getRenderedTemplate("templates/" + page + ".vm", context);
        return Response.ok(StringEscapeUtils.unescapeHtml(content)).build();
    }
}
