package com.prodyna.dataprotection.navigator.model.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * This class provides the DAO of a feedback line.
 *
 * @see com.prodyna.dataprotection.navigator.service.reportingservices.FeedbackReportService
 * @see com.prodyna.dataprotection.navigator.controller.FeedbackController
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedbackReportLineDTO implements Serializable {

    private long id;

    private int stars;

    private String comment;

    public FeedbackReportLineDTO() {
    }

    public FeedbackReportLineDTO(long id, int stars, String comment) {
        this.id = id;
        this.stars = stars;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
