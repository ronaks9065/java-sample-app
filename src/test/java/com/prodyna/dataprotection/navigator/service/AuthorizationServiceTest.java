package com.prodyna.dataprotection.navigator.service;

import com.atlassian.confluence.user.ConfluenceUser;
import com.atlassian.sal.api.user.UserKey;
import com.atlassian.sal.api.user.UserManager;
import com.prodyna.dataprotection.navigator.model.ConfigurationData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class AuthorizationServiceTest {
    private final UserManager userManager = mock(UserManager.class);
    private final ConfigurationService configurationService = mock(ConfigurationService.class);
    private final UserKey key = new UserKey("userKey");
    private final ConfluenceUser user = mock(ConfluenceUser.class);
    private AuthorizationService authorizationService;
    private ConfigurationData configurationData;

    @Before
    public void setUp() {
        authorizationService = new AuthorizationService(userManager, configurationService);
        doReturn(key).when(user).getKey();
        configurationData = new ConfigurationData();
    }

    @Test
    public void givenNoUser_WhenChangingConfiguration_ThenFailure() {
        assertFalse("User should not be able to change Configuration", authorizationService.isUserAllowedToChangeConfiguration(null));
    }

    @Test
    public void givenUserIsNoAdmin_WhenChangingConfiguration_ThenFailure() {
        doReturn(false).when(userManager).isAdmin(key);
        doReturn(false).when(userManager).isSystemAdmin(key);

        assertFalse("User should not be able to change Configuration", authorizationService.isUserAllowedToChangeConfiguration(user));
    }

    @Test
    public void givenUserIsAdmin_WhenChangingConfiguration_ThenSuccess() {
        doReturn(true).when(userManager).isAdmin(key);
        doReturn(false).when(userManager).isSystemAdmin(key);

        assertTrue("User should be able to change Configuration", authorizationService.isUserAllowedToChangeConfiguration(user));
    }

    @Test
    public void givenUserIsNoAdminAndHasRole_WhenChangingConfiguration_ThenFailure() {
        doReturn(false).when(userManager).isAdmin(key);
        doReturn(false).when(userManager).isSystemAdmin(key);
        configurationData.setRequiredRole("Role");
        doReturn(configurationData).when(configurationService).getConfigurationData();
        doReturn(true).when(userManager).isUserInGroup(key,
                "Role");
        assertFalse("User should Not be able to change Configuration", authorizationService.isUserAllowedToChangeConfiguration(user));
    }


    @Test
    public void givenUserIsNoAdminAndNoRoleGiven_WhenAccessingReport_ThenFailure() {
        doReturn(false).when(userManager).isAdmin(key);
        doReturn(false).when(userManager).isSystemAdmin(key);
        doReturn(configurationData).when(configurationService).getConfigurationData();

        assertFalse("User should not be able to access Report", authorizationService.isAllowedToAccessReports(user));
    }

    @Test
    public void givenUserIsNoAdminAndNotHasRole_WhenAccessingReport_ThenFailure() {
        doReturn(false).when(userManager).isAdmin(key);
        doReturn(false).when(userManager).isSystemAdmin(key);
        configurationData.setRequiredRole("Role");
        doReturn(configurationData).when(configurationService).getConfigurationData();
        doReturn(false).when(userManager).isUserInGroup(key, "Role");

        assertFalse("User should not be able to access Report", authorizationService.isAllowedToAccessReports(user));
    }

    @Test
    public void givenUserIsNoAdminAndHasRole_WhenAccessingReport_ThenSuccess() {
        doReturn(false).when(userManager).isAdmin(key);
        doReturn(false).when(userManager).isSystemAdmin(key);
        configurationData.setRequiredRole("Role");
        doReturn(configurationData).when(configurationService).getConfigurationData();
        doReturn(true).when(userManager).isUserInGroup(key, "Role");

        assertTrue("User should be able to access Report", authorizationService.isAllowedToAccessReports(user));
    }

    @Test
    public void givenUserIsAdmin_WhenAccessingReport_ThenSuccess() {
        doReturn(true).when(userManager).isAdmin(key);
        doReturn(false).when(userManager).isSystemAdmin(key);

        assertTrue("User should be able to access Report", authorizationService.isAllowedToAccessReports(user));
    }

    @Test
    public void givenNoUser_WhenAccessingReport_ThenFailure() {
        assertFalse("User should not be able to access Report", authorizationService.isAllowedToAccessReports(null));
    }
}
