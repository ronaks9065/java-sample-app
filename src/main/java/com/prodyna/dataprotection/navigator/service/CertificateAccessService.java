package com.prodyna.dataprotection.navigator.service;

import com.prodyna.dataprotection.navigator.model.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

/**
 * The service class for access to certificates.
 */

@Named
public class CertificateAccessService {

    private final UserService userService;

    @Inject
    public CertificateAccessService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Sets the time when the user access the certificate for reporting purposes
     *
     * @param userId The id of the user.
     * @param level  The level, the user wants to download the certificate for.
     */

    public void setUserAccessedCertificate(String userId, int level) {
        User user = userService.getUserById(userId);
        switch (level) {
            case 1:
                if (user.getBasicCertificateAccessed() == null) {
                    user.setBasicCertificateAccessed(new Date());
                }
                break;
            case 2:
                if (user.getAdvancedCertificateAccessed() == null) {
                    user.setAdvancedCertificateAccessed(new Date());
                }
                break;
            case 4:
                if (user.getExpertCertificateAccessed() == null) {
                    user.setExpertCertificateAccessed(new Date());
                }
                break;
        }
        userService.updateBandanaUser(user);
    }
}
