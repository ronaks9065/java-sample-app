package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class provides the DTO of a user.
 *
 * @see com.prodyna.dataprotection.navigator.service.reportingservices.UserReportingService
 */

@XmlRootElement(name = "UserReporting")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserReportingDTO implements ReportingDTO {

    private int uniqueVisitors;
    private int sessions;
    private int baseSessions;
    private int advancedSessions;
    private int expertSessions;

    public UserReportingDTO() {
    }

    public UserReportingDTO(
            int uniqueVisitors,
            int sessions,
            int baseSessions,
            int advancedSessions,
            int expertSessions
    ) {
        this.uniqueVisitors = uniqueVisitors;
        this.sessions = sessions;
        this.baseSessions = baseSessions;
        this.advancedSessions = advancedSessions;
        this.expertSessions = expertSessions;
    }

    public int getUniqueVisitors() {
        return uniqueVisitors;
    }

    public void setUniqueVisitors(int uniqueVisitors) {
        this.uniqueVisitors = uniqueVisitors;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public int getBaseSessions() {
        return baseSessions;
    }

    public void setBaseSessions(int baseSessions) {
        this.baseSessions = baseSessions;
    }

    public int getAdvancedSessions() {
        return advancedSessions;
    }

    public void setAdvancedSessions(int advancedSessions) {
        this.advancedSessions = advancedSessions;
    }

    public int getExpertSessions() {
        return expertSessions;
    }

    public void setExpertSessions(int expertSessions) {
        this.expertSessions = expertSessions;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nutzer;").append(System.lineSeparator());
        sb.append("Besucher;Sessions Gesamt; Sessions Basiswissen;Sessions Anwenderwissen; Sessions F\u00FChrungskr\u00E4ftewissen;")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(uniqueVisitors).append(";")
                .append(sessions).append(";")
                .append(baseSessions).append(";")
                .append(advancedSessions).append(";")
                .append(expertSessions).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }
}
