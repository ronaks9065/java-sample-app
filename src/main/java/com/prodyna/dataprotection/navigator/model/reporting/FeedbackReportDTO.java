package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the DAO of feedback reports.
 *
 * @see com.prodyna.dataprotection.navigator.service.reportingservices.FeedbackReportService
 * @see com.prodyna.dataprotection.navigator.controller.FeedbackController
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedbackReportDTO implements ReportingDTO {

    private long oneStar;
    private long twoStars;
    private long threeStars;
    private long fourStars;
    private long fiveStars;

    private List<FeedbackReportLineDTO> feedbackLines = new ArrayList<>();

    public FeedbackReportDTO() {
    }

    public FeedbackReportDTO(
            long oneStar,
            long twoStars,
            long threeStars,
            long fourStars,
            long fiveStars,
            List<FeedbackReportLineDTO> feedbackLines
    ) {
        this.oneStar = oneStar;
        this.twoStars = twoStars;
        this.threeStars = threeStars;
        this.fourStars = fourStars;
        this.fiveStars = fiveStars;
        this.feedbackLines = feedbackLines;
    }

    public long getOneStar() {
        return oneStar;
    }

    public void setOneStar(long oneStar) {
        this.oneStar = oneStar;
    }

    public long getTwoStars() {
        return twoStars;
    }

    public void setTwoStars(long twoStars) {
        this.twoStars = twoStars;
    }

    public long getThreeStars() {
        return threeStars;
    }

    public void setThreeStars(long threeStars) {
        this.threeStars = threeStars;
    }

    public long getFourStars() {
        return fourStars;
    }

    public void setFourStars(long fourStars) {
        this.fourStars = fourStars;
    }

    public long getFiveStars() {
        return fiveStars;
    }

    public void setFiveStars(long fiveStars) {
        this.fiveStars = fiveStars;
    }

    public List<FeedbackReportLineDTO> getFeedbackLines() {
        return feedbackLines;
    }

    public void setFeedbackLines(List<FeedbackReportLineDTO> feedbackLines) {
        this.feedbackLines = feedbackLines;
    }

    public void addFeedbackLine(FeedbackReportLineDTO feedbackReportLine) {
        this.feedbackLines.add(feedbackReportLine);
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("Feedback;").append(System.lineSeparator());
        sb.append(";Anzahl;").append(System.lineSeparator());
        sb.append("1 Stern;").append(oneStar).append(";").append(System.lineSeparator());
        sb.append("2 Sterne;").append(twoStars).append(";").append(System.lineSeparator());
        sb.append("3 Sterne;").append(threeStars).append(";").append(System.lineSeparator());
        sb.append("4 Sterne;").append(fourStars).append(";").append(System.lineSeparator());
        sb.append("5 Sterne;").append(fiveStars).append(";").append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("ID;Sterne;Kommentar;").append(System.lineSeparator());
        for (FeedbackReportLineDTO feedback : feedbackLines) {
            sb.append(feedback.getId()).append(";")
                    .append(feedback.getStars()).append(";")
                    .append(feedback.getComment()).append(";").append(System.lineSeparator());
        }
        sb.append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }
}
