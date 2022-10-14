package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Objects;

/**
 * This class provides the DAO of a time dataset for a quiz regarding reporting purposes.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TimeRequiredLineDTO {

    private String quizName;
    private Long accessedAmount;
    private Long finishedAmount;
    private Long minimumTime;
    private Long maximumTime;
    private Double averageTime;

    public TimeRequiredLineDTO() {
    }

    public TimeRequiredLineDTO(
            String quizName,
            Long accessedAmount,
            Long finishedAmount,
            Long minimumTime,
            Long maximumTime,
            Double averageTime
    ) {
        this.quizName = quizName;
        this.accessedAmount = accessedAmount;
        this.finishedAmount = finishedAmount;
        this.minimumTime = minimumTime;
        this.maximumTime = maximumTime;
        this.averageTime = averageTime;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Long getAccessedAmount() {
        return accessedAmount;
    }

    public void setAccessedAmount(Long accessedAmount) {
        this.accessedAmount = accessedAmount;
    }

    public Long getFinishedAmount() {
        return finishedAmount;
    }

    public void setFinishedAmount(Long finishedAmount) {
        this.finishedAmount = finishedAmount;
    }

    public Long getMinimumTime() {
        return minimumTime;
    }

    public void setMinimumTime(Long minimumTime) {
        this.minimumTime = minimumTime;
    }

    public Long getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(Long maximumTime) {
        this.maximumTime = maximumTime;
    }

    public Double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Double averageTime) {
        this.averageTime = averageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TimeRequiredLineDTO that = (TimeRequiredLineDTO) o;
        return Objects.equals(quizName, that.quizName) &&
                Objects.equals(accessedAmount, that.accessedAmount) &&
                Objects.equals(finishedAmount, that.finishedAmount) &&
                Objects.equals(minimumTime, that.minimumTime) &&
                Objects.equals(maximumTime, that.maximumTime) &&
                Objects.equals(averageTime, that.averageTime);
    }
}
