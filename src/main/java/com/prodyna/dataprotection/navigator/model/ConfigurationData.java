package com.prodyna.dataprotection.navigator.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Represents the Configuration data.
 */
@XmlRootElement(name = "Configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigurationData implements Serializable {

    private String dpnSpaceKey;

    private String requiredRole;

    public ConfigurationData() {
    }

    public ConfigurationData(String dpnSpaceKey) {
        this.dpnSpaceKey = dpnSpaceKey;
    }

    public String getDpnSpaceKey() {
        return dpnSpaceKey;
    }

    public void setDpnSpaceKey(String dpnSpaceKey) {
        this.dpnSpaceKey = dpnSpaceKey;
    }

    public String getRequiredRole() {
        return requiredRole;
    }

    public void setRequiredRole(String requiredRole) {
        this.requiredRole = requiredRole;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "dpnSpaceKey='" + dpnSpaceKey + "'" +
                ", requiredRole='" + requiredRole + "'" +
                '}';
    }
}
