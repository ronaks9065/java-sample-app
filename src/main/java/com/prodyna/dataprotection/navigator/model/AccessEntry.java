package com.prodyna.dataprotection.navigator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents an access entry consists of accessTime and DeviceType
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessEntry implements Serializable {

    private Date accessTime;
    private DeviceType accessDevice;

    public AccessEntry() {
    }

    public AccessEntry(Date accessTime, DeviceType accessDevice) {
        this.accessTime = accessTime;
        this.accessDevice = accessDevice;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public DeviceType getAccessDevice() {
        return accessDevice;
    }

    public void setAccessDevice(DeviceType accessDevice) {
        this.accessDevice = accessDevice;
    }

    @Override
    public String toString() {
        return "{deviceType: " + accessDevice + ", accessTime: " + accessTime + "}";
    }
}
