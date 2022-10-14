package com.prodyna.dataprotection.navigator.controller;

import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.transaction.TransactionTemplate;
import com.prodyna.dataprotection.navigator.model.ConfigurationData;
import com.prodyna.dataprotection.navigator.service.AuthorizationService;
import com.prodyna.dataprotection.navigator.service.ConfigurationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * confluence/rest/dpn/1.0/admin/configuration
 * This class provides endpoints to load or modify the configuration.
 *
 * @see com.prodyna.dataprotection.navigator.service.ConfigurationService
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("admin/configuration")
public class ConfigurationController {

    private final TransactionTemplate transactionTemplate;
    private final ConfigurationService configurationService;
    private final AuthorizationService authorizationService;

    @Inject
    public ConfigurationController(
            @ComponentImport TransactionTemplate transactionTemplate,
            ConfigurationService configurationService,
            AuthorizationService authorizationService
    ) {
        this.transactionTemplate = transactionTemplate;
        this.configurationService = configurationService;
        this.authorizationService = authorizationService;
    }

    /**
     * This endpoint returns the Configuration Data
     *
     * @return 200, responds with configuration data if the user is authorized to access
     * the configuration data, otherwise 401.
     */

    @GET
    public Response getConfiguration() {
        if (!authorizationService.isUserAllowedToChangeConfiguration(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok(transactionTemplate.execute(configurationService::getConfigurationData)).build();
    }

    /**
     * This Endpoint takes the ConfigurationData to save it
     *
     * @param configurationData This data is vital for all authorizations.
     * @return 401. If the user is not authorized to change the configuration.
     * @see com.prodyna.dataprotection.navigator.model.ConfigurationData
     */

    @PUT
    public Response setConfiguration(ConfigurationData configurationData) {
        if (!authorizationService.isUserAllowedToChangeConfiguration(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        transactionTemplate.execute(() -> configurationService.setConfigurationData(configurationData));
        return Response.noContent().build();
    }
}
