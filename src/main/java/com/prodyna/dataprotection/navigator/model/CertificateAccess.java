package com.prodyna.dataprotection.navigator.model;

import java.util.Date;

/**
 * Represents the Dates, where a specific user accessed a certificate
 */
class CertificateAccess {

    private String userId;
    private Date basicAccessed;
    private Date advancedAccessed;
    private Date expertAccessed;

    public CertificateAccess() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBasicAccessed() {
        return basicAccessed;
    }

    public void setBasicAccessed(Date basicAccessed) {
        this.basicAccessed = basicAccessed;
    }

    public Date getAdvancedAccessed() {
        return advancedAccessed;
    }

    public void setAdvancedAccessed(Date advancedAccessed) {
        this.advancedAccessed = advancedAccessed;
    }

    public Date getExpertAccessed() {
        return expertAccessed;
    }

    public void setExpertAccessed(Date expertAccessed) {
        this.expertAccessed = expertAccessed;
    }
}
