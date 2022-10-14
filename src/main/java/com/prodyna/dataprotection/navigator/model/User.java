package com.prodyna.dataprotection.navigator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents a user.
 */
@XmlRootElement(name = "Users")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

    private String userId;
    private List<QuizItem> quizes;
    private List<AccessEntry> accessEntries;

    private Date basicCertificateAccessed;
    private Date advancedCertificateAccessed;
    private Date expertCertificateAccessed;

    private Feedback feedback;

    public User() {
        this.quizes = new ArrayList<>();
        this.accessEntries = new ArrayList<>();
    }

    public User(String userId) {
        this.userId = userId;
        this.quizes = new ArrayList<>();
        this.accessEntries = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<QuizItem> getQuizes() {
        return quizes;
    }

    public void setQuizes(List<QuizItem> quizes) {
        this.quizes = quizes;
    }

    public void addQuiz(QuizItem quiz) {
        this.quizes.add(quiz);
    }

    public List<AccessEntry> getAccessEntries() {
        return accessEntries;
    }

    public void setAccessEntries(List<AccessEntry> accessEntry) {
        this.accessEntries = accessEntry;
    }

    public void addAccessEntry(AccessEntry accessEntry) {
        this.accessEntries.add(accessEntry);
    }

    public Date getBasicCertificateAccessed() {
        return basicCertificateAccessed;
    }

    public void setBasicCertificateAccessed(Date basicCertificateAccessed) {
        this.basicCertificateAccessed = basicCertificateAccessed;
    }

    public Date getAdvancedCertificateAccessed() {
        return advancedCertificateAccessed;
    }

    public void setAdvancedCertificateAccessed(Date advancedCertificateAccessed) {
        this.advancedCertificateAccessed = advancedCertificateAccessed;
    }

    public Date getExpertCertificateAccessed() {
        return expertCertificateAccessed;
    }

    public void setExpertCertificateAccessed(Date expertCertificateAccessed) {
        this.expertCertificateAccessed = expertCertificateAccessed;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User{").append(System.lineSeparator());
        stringBuilder.append("userId='").append(userId).append("',").append(System.lineSeparator());
        stringBuilder.append("userAgentStrings=[").append(System.lineSeparator());
        stringBuilder.append("quizes=[").append(System.lineSeparator());
        for (QuizItem quizItem : quizes) {
            stringBuilder.append("\t").append(quizItem).append(System.lineSeparator());
        }
        stringBuilder.append("],").append(System.lineSeparator());
        stringBuilder.append("accessTimes=[").append(System.lineSeparator());
        for (AccessEntry accessEntry : accessEntries) {
            stringBuilder.append("\t").append(accessEntry).append(System.lineSeparator());
        }
        stringBuilder.append("],").append(System.lineSeparator());
        stringBuilder.append("BasicCertificateAccessed=").append(basicCertificateAccessed).append(",").append(System.lineSeparator());
        stringBuilder.append("AdvancedCertificateAccessed=").append(advancedCertificateAccessed).append(",").append(System.lineSeparator());
        stringBuilder.append("ExpertCertificateAccessed=").append(expertCertificateAccessed).append(",").append(System.lineSeparator());
        stringBuilder.append("Feedback=").append(feedback).append(System.lineSeparator());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
