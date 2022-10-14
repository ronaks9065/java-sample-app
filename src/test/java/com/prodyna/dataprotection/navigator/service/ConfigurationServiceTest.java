package com.prodyna.dataprotection.navigator.service;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.prodyna.dataprotection.navigator.model.ConfigurationData;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static com.prodyna.dataprotection.navigator.service.ConfigurationService.DPN_CONFIGURATION_KEY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class ConfigurationServiceTest {
    private final BandanaManager bandanaManager = mock(BandanaManager.class);
    private ConfigurationService configurationService;

    @Before
    public void setUp() {
        configurationService = new ConfigurationService(bandanaManager);
    }

    @Test
    public void givenNoConfigurationPresent_WhenGettingData_ThenDefault() {
        assertEquals("Default value should have been returned", "VWDN", configurationService.getConfigurationData().getDpnSpaceKey());
        assertNull("Default value should have been returned", configurationService.getConfigurationData().getRequiredRole());
    }

    @Test
    public void givenConfigurationPresent_WhenGettingData_ThenConfiguration() throws IOException {
        ConfigurationData configurationData = new ConfigurationData();
        configurationData.setRequiredRole("Role");
        configurationData.setDpnSpaceKey("Key");

        doReturn(new ObjectMapper().writeValueAsString(configurationData)).when(bandanaManager).getValue(any(BandanaContext.class), eq(DPN_CONFIGURATION_KEY));

        assertEquals("Value should have been returned", "Key", configurationService.getConfigurationData().getDpnSpaceKey());
        assertEquals("Value should have been returned", "Role", configurationService.getConfigurationData().getRequiredRole());
    }

    @Test
    public void givenConfiguration_WhenSettingConfiguration_ThenBandanaIsUpdated() throws IOException {
        ConfigurationData configurationData = new ConfigurationData();

        configurationService.setConfigurationData(configurationData);

        verify(bandanaManager, times(1)).setValue(any(BandanaContext.class), eq(DPN_CONFIGURATION_KEY), eq(new ObjectMapper().writeValueAsString(configurationData)));
    }
}
