package com.prodyna.dataprotection.navigator.service;

import com.prodyna.dataprotection.navigator.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class CertificateAccessServiceTest {
    private CertificateAccessService certificateAccessService;
    private User user;

    @Before
    public void setup() {
        UserService userService = mock(UserService.class);
        certificateAccessService = new CertificateAccessService(userService);
        user = new User();
        doReturn(user).when(userService).getUserById("userId");
    }

    @Test
    public void given_WhenUserAccessesCertificateLvl1_ThenDataIsUpdated() {
        certificateAccessService.setUserAccessedCertificate("userId", 1);
        assertNotNull("date for BaseCertificateAccessed should be set", user.getBasicCertificateAccessed());
    }

    @Test
    public void given_WhenUserAccessesCertificateLvl2_ThenDataIsUpdated() {
        certificateAccessService.setUserAccessedCertificate("userId", 2);
        assertNotNull("date for AdvancedCertificateAccessed should be set", user.getAdvancedCertificateAccessed());
    }

    @Test
    public void given_WhenUserAccessesCertificateLvl4_ThenDataIsUpdated() {
        certificateAccessService.setUserAccessedCertificate("userId", 4);
        assertNotNull("date for ExpertCertificateAccessed should be set", user.getExpertCertificateAccessed());
    }
}
