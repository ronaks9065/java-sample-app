package com.prodyna.dataprotection.navigator.service;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.prodyna.dataprotection.navigator.action.WelcomeAction;
import com.prodyna.dataprotection.navigator.model.ConfigurationData;
import com.prodyna.dataprotection.navigator.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

/**
 * The service class for configuration to set and get the configuration data.
 */
@Named
public class ConfigurationService {

    public static final String DPN_CONFIGURATION_KEY = "DPNConfiguration";

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationService.class);

    private final BandanaManager bandanaManager;

    @Inject
    public ConfigurationService(@ComponentImport BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    /**
     * Retrieves the configurationDate from Bandana
     *
     * @return the ConfigurationData
     */
    public ConfigurationData getConfigurationData() {
        ConfluenceBandanaContext ctx = new ConfluenceBandanaContext(WelcomeAction.DPN_BANDANA_KEY);
        ConfigurationData configurationData = null;
        try {
            String configurationDataString = (String) bandanaManager.getValue(ctx, DPN_CONFIGURATION_KEY);
            configurationData = JsonUtils.fromJson(configurationDataString, ConfigurationData.class);
        } catch (NullPointerException e) {
            LOGGER.info("No object found... Creating a new one...");
        } catch (Exception e) {
            // Catch every exception like NPE, ClassCast, etc.
            // Based on the Serialization there are multiple possibilities that anything can go wrong
            e.printStackTrace();
        }
        if (configurationData == null) {
            configurationData = new ConfigurationData("VWDN");
            setConfigurationData(configurationData);
        }
        return configurationData;
    }

    /**
     * Saves the configurationData to Bandana
     *
     * @param configurationData The configurationData to save
     * @return Returns nothing. The return is only needed so the function can be passed to a lambda.
     */
    public Object setConfigurationData(ConfigurationData configurationData) {
        ConfluenceBandanaContext ctx = new ConfluenceBandanaContext(WelcomeAction.DPN_BANDANA_KEY);
        try {
            String configurationDataString = JsonUtils.toJson(configurationData);
            bandanaManager.setValue(ctx, DPN_CONFIGURATION_KEY, configurationDataString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
