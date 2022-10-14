package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * This class provides the DAO of used devices for reporting purposes.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class SourceReportDTO implements ReportingDTO {

    private long desktop;
    private long tablet;
    private long mobile;

    public SourceReportDTO() {
    }

    public long getDesktop() {
        return desktop;
    }

    public void setDesktop(long desktop) {
        this.desktop = desktop;
    }

    public long getTablet() {
        return tablet;
    }

    public void setTablet(long tablet) {
        this.tablet = tablet;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("Genutzte Endger\u00E4te;").append(System.lineSeparator());
        sb.append("Desktop;Tablet;Handy;").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(desktop).append(";")
                .append(tablet).append(";")
                .append(mobile).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }
}
