package com.prodyna.dataprotection.navigator.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Represents a Feedback.
 * This model consists of a Date, the comment of the user and the score given.
 */
@XmlRootElement(name = "Feedback")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feedback implements Serializable {

    private int score;

    private String comment;

    private Date date;

    public Feedback() {
    }

    public Feedback(int score, String comment) {
        this.score = score;
        this.comment = comment;
        this.date = new Date();
    }

    public Feedback(int score, String comment, Date date) {
        this.score = score;
        this.comment = comment;
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "date=" + date +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Feedback)) {
            return false;
        }
        Feedback otherFeedback = (Feedback) other;
        return Objects.equals(score, otherFeedback.getScore()) &&
                Objects.equals(comment, otherFeedback.getComment()) &&
                Objects.equals(date, otherFeedback.getDate());
    }
}
