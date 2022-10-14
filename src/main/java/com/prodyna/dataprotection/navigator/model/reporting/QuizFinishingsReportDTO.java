package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

/**
 * This class provides the DAO of Completion of Quizzes for reporting purposes.
 */
@XmlRootElement(name = "QuizFinishings")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuizFinishingsReportDTO implements ReportingDTO {

    private Long allCertificatsReceived;

    private Long baseCertificatesReceived;
    private Long baseResultsSum;
    private List<Long> baseResults;

    private Long advancedCertificatesReceived;
    private Long advancedResultsSum;
    private List<Long> advancedResults;

    private Long expertCertificatesReceived;
    private Long expertResultsSum;
    private List<Long> expertResults;

    public QuizFinishingsReportDTO() {
    }

    public Long getAllCertificatsReceived() {
        return allCertificatsReceived;
    }

    public void setAllCertificatsReceived(Long allCertificatsReceived) {
        this.allCertificatsReceived = allCertificatsReceived;
    }

    public Long getBaseCertificatesReceived() {
        return baseCertificatesReceived;
    }

    public void setBaseCertificatesReceived(Long baseCertificatesReceived) {
        this.baseCertificatesReceived = baseCertificatesReceived;
    }

    public Long getBaseResultsSum() {
        return baseResultsSum;
    }

    public void setBaseResultsSum(Long baseResultsSum) {
        this.baseResultsSum = baseResultsSum;
    }

    public List<Long> getBaseResults() {
        return baseResults;
    }

    public void setBaseResults(List<Long> baseResults) {
        this.baseResults = baseResults;
    }

    public Long getAdvancedCertificatesReceived() {
        return advancedCertificatesReceived;
    }

    public void setAdvancedCertificatesReceived(Long advancedCertificatesReceived) {
        this.advancedCertificatesReceived = advancedCertificatesReceived;
    }

    public Long getAdvancedResultsSum() {
        return advancedResultsSum;
    }

    public void setAdvancedResultsSum(Long advancedResultsSum) {
        this.advancedResultsSum = advancedResultsSum;
    }

    public List<Long> getAdvancedResults() {
        return advancedResults;
    }

    public void setAdvancedResults(List<Long> advancedResults) {
        this.advancedResults = advancedResults;
    }

    public Long getExpertCertificatesReceived() {
        return expertCertificatesReceived;
    }

    public void setExpertCertificatesReceived(Long expertCertificatesReceived) {
        this.expertCertificatesReceived = expertCertificatesReceived;
    }

    public Long getExpertResultsSum() {
        return expertResultsSum;
    }

    public void setExpertResultsSum(Long expertResultsSum) {
        this.expertResultsSum = expertResultsSum;
    }

    public List<Long> getExpertResults() {
        return expertResults;
    }

    public void setExpertResults(List<Long> expertResults) {
        this.expertResults = expertResults;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("Abschl\u00FCsse;").append(System.lineSeparator());
        sb.append("Topic;Basiswissen;Anwenderwissen;F\u00FChrungskr\u00E4ftewissen;")
                .append(System.lineSeparator()).append(System.lineSeparator())
                .append("Gesamt;")
                .append(baseResultsSum).append(";")
                .append(advancedResultsSum).append(";")
                .append(expertResultsSum).append(";")
                .append(System.lineSeparator());
        for (int i = 0; i < 13; i++) {
            sb.append(i).append(";")
                    .append(baseResults.get(i)).append(";")
                    .append(advancedResults.get(i)).append(";");
            if (i < 7) {
                sb.append(expertResults.get(i));
            } else {
                sb.append("-");
            }
            sb.append(";").append(System.lineSeparator());
        }
        sb.append("Abgerufene Zertifikate;")
                .append(baseCertificatesReceived).append(";")
                .append(advancedCertificatesReceived).append(";")
                .append(expertCertificatesReceived).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator()).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuizFinishingsReportDTO that = (QuizFinishingsReportDTO) o;
        return Objects.equals(allCertificatsReceived, that.allCertificatsReceived) &&
                Objects.equals(baseCertificatesReceived, that.baseCertificatesReceived) &&
                Objects.equals(baseResultsSum, that.baseResultsSum) &&
                Objects.equals(baseResults, that.baseResults) &&
                Objects.equals(advancedCertificatesReceived, that.advancedCertificatesReceived) &&
                Objects.equals(advancedResultsSum, that.advancedResultsSum) &&
                Objects.equals(advancedResults, that.advancedResults) &&
                Objects.equals(expertCertificatesReceived, that.expertCertificatesReceived) &&
                Objects.equals(expertResultsSum, that.expertResultsSum) &&
                Objects.equals(expertResults, that.expertResults);
    }
}
