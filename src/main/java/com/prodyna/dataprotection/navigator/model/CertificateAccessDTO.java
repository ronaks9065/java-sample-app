package com.prodyna.dataprotection.navigator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Represents the name of the user, who tries to access the certificate.
 */
@XmlRootElement(name = "certificateAccessDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class CertificateAccessDTO implements Serializable {

    private String name;

    public CertificateAccessDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
