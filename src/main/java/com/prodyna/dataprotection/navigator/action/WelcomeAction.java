package com.prodyna.dataprotection.navigator.action;

import com.atlassian.confluence.core.ConfluenceActionSupport;

/**
 * This action is performed after clicking the URL in the confluence header.
 * This will load the dpn.vm in the resources and redirect to the web app.
 */
public class WelcomeAction extends ConfluenceActionSupport {

    public static final String DPN_BANDANA_KEY = "com.prodyna.dataprotectionnavigator.bandanakey";

    public String execute() {
        return "welcome";
    }

}
