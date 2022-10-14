package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;


/**
 * This class provides the DAO of  time datasets for all levels regarding reporting purposes.
 */
@XmlRootElement(name = "TimeRequired")
@XmlAccessorType(XmlAccessType.FIELD)
public class TimeRequiredReportingDTO implements ReportingDTO {

    private List<TimeRequiredLineDTO> timesRequiredForBase;
    private List<TimeRequiredLineDTO> timesRequiredForAdvanced;
    private List<TimeRequiredLineDTO> timesRequiredForExpert;

    public TimeRequiredReportingDTO() {
    }

    public TimeRequiredReportingDTO(
            List<TimeRequiredLineDTO> timesRequiredForBase,
            List<TimeRequiredLineDTO> timesRequiredForAdvanced,
            List<TimeRequiredLineDTO> timesRequiredForExpert
    ) {
        this.timesRequiredForBase = timesRequiredForBase;
        this.timesRequiredForAdvanced = timesRequiredForAdvanced;
        this.timesRequiredForExpert = timesRequiredForExpert;
    }

    public List<TimeRequiredLineDTO> getTimesRequiredForBase() {
        return timesRequiredForBase;
    }

    public void setTimesRequiredForBase(List<TimeRequiredLineDTO> timesRequiredForBase) {
        this.timesRequiredForBase = timesRequiredForBase;
    }

    public void addTimesRequiredForBase(TimeRequiredLineDTO timeRequiredLineDTO) {
        this.timesRequiredForBase.add(timeRequiredLineDTO);
    }

    public List<TimeRequiredLineDTO> getTimesRequiredForAdvanced() {
        return timesRequiredForAdvanced;
    }

    public void setTimesRequiredForAdvanced(List<TimeRequiredLineDTO> timesRequiredForAdvanced) {
        this.timesRequiredForAdvanced = timesRequiredForAdvanced;
    }

    public void addTimesRequiredForAdvanced(TimeRequiredLineDTO timeRequiredLineDTO) {
        this.timesRequiredForAdvanced.add(timeRequiredLineDTO);
    }

    public List<TimeRequiredLineDTO> getTimesRequiredForExpert() {
        return timesRequiredForExpert;
    }

    public void setTimesRequiredForExpert(List<TimeRequiredLineDTO> timesRequiredForExpert) {
        this.timesRequiredForExpert = timesRequiredForExpert;
    }

    public void addTimesRequiredForExpert(TimeRequiredLineDTO timeRequiredLineDTO) {
        this.timesRequiredForExpert.add(timeRequiredLineDTO);
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ben\u00F6tigte Zeit;").append(System.lineSeparator());
        sb.append("Level;Topic;Angefangen;Beendet;Minimale Zeit in Sek.;Maximale Zeit in Sek.;Durchschnittliche Zeit in Sek.;")
                .append(System.lineSeparator())
                .append(System.lineSeparator());
        sb.append(getEntriesForLevel(1));
        sb.append(getEntriesForLevel(2));
        sb.append(getEntriesForLevel(4));
        sb.append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private String getEntriesForLevel(int level) {
        StringBuilder sb = new StringBuilder();
        int maxLevel = level == 4 ? 7 : 13;
        String display = getDisplayText(level);
        for (int i = 0; i < maxLevel; i++) {
            TimeRequiredLineDTO timeRequiredLine = getTimeRequiredLine(level, i);
            if (i == 0) {
                sb.append(display).append(";");
            } else {
                sb.append(";");
            }
            sb.append(timeRequiredLine.getQuizName()).append(";")
                    .append(timeRequiredLine.getAccessedAmount()).append(";")
                    .append(timeRequiredLine.getFinishedAmount()).append(";")
                    .append(timeRequiredLine.getMinimumTime()).append(";")
                    .append(timeRequiredLine.getMaximumTime()).append(";")
                    .append(timeRequiredLine.getAverageTime()).append(";")
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    private String getDisplayText(int level) {
        if (level == 1) {
            return "Basiswissen";
        } else if (level == 2) {
            return "Anwenderwissen";
        }
        return "F\u00FChrungskr\u00E4ftewissen";
    }

    private TimeRequiredLineDTO getTimeRequiredLine(int level, int itemNumber) {
        if (level == 1) {
            return timesRequiredForBase.get(itemNumber);
        } else if (level == 2) {
            return timesRequiredForAdvanced.get(itemNumber);
        }
        return timesRequiredForExpert.get(itemNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TimeRequiredReportingDTO that = (TimeRequiredReportingDTO) o;
        return Objects.equals(timesRequiredForBase, that.timesRequiredForBase) &&
                Objects.equals(timesRequiredForAdvanced, that.timesRequiredForAdvanced) &&
                Objects.equals(timesRequiredForExpert, that.timesRequiredForExpert);
    }
}
