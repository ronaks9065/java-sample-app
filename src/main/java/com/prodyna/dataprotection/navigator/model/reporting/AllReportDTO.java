package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * This class provides the DAO of all reports.
 *
 * @see com.prodyna.dataprotection.navigator.service.reportingservices.ReportingService
 * @see com.prodyna.dataprotection.navigator.controller.ReportingController
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AllReportDTO {

    private String taskId;

    private UserReportingDTO userReportingDTO;
    private QuizFinishingsReportDTO quizFinishingsReportDTO;
    private TimeRequiredReportingDTO timeRequiredReportingDTO;
    private SourceReportDTO sourceReportDTO;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public UserReportingDTO getUserReportingDTO() {
        return userReportingDTO;
    }

    public void setUserReportingDTO(UserReportingDTO userReportingDTO) {
        this.userReportingDTO = userReportingDTO;
    }

    public QuizFinishingsReportDTO getQuizFinishingsReportDTO() {
        return quizFinishingsReportDTO;
    }

    public void setQuizFinishingsReportDTO(QuizFinishingsReportDTO quizFinishingsReportDTO) {
        this.quizFinishingsReportDTO = quizFinishingsReportDTO;
    }

    public TimeRequiredReportingDTO getTimeRequiredReportingDTO() {
        return timeRequiredReportingDTO;
    }

    public void setTimeRequiredReportingDTO(TimeRequiredReportingDTO timeRequiredReportingDTO) {
        this.timeRequiredReportingDTO = timeRequiredReportingDTO;
    }

    public SourceReportDTO getSourceReportDTO() {
        return sourceReportDTO;
    }

    public void setSourceReportDTO(SourceReportDTO sourceReportDTO) {
        this.sourceReportDTO = sourceReportDTO;
    }
}
