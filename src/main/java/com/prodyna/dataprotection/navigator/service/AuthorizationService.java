package com.prodyna.dataprotection.navigator.service;

import com.atlassian.confluence.user.ConfluenceUser;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.user.UserKey;
import com.atlassian.sal.api.user.UserManager;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Defines the authorization functions.
 */

@Named
public class AuthorizationService {

    private final UserManager userManager;

    private final ConfigurationService configurationService;

    @Inject
    public AuthorizationService(
            @ComponentImport UserManager userManager,
            ConfigurationService configurationService
    ) {
        this.userManager = userManager;
        this.configurationService = configurationService;
    }

    /**
     * @param user A confluence user, who tries to change the configuration.
     * @return True , if the user is admin or system admin, otherwise false.
     */

    public boolean isUserAllowedToChangeConfiguration(ConfluenceUser user) {
        if (user == null) {
            return false;
        }
        UserKey userKey = user.getKey();
        return userManager.isAdmin(userKey) || userManager.isSystemAdmin(userKey);
    }

    /**
     * @param user A confluence user, who tries to access the reports.
     * @return True , if the user has the required role, if given, is admin or system admin.
     */
    public boolean isAllowedToAccessReports(ConfluenceUser user) {
        if (user == null) {
            return false;
        }
        if (isUserAllowedToChangeConfiguration(user)) {
            return true;
        }
        String requiredRole = configurationService.getConfigurationData().getRequiredRole();
        if (requiredRole == null) {
            return false;
        }
        return userManager.isUserInGroup(user.getKey(), requiredRole);
    }
}
