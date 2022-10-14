package com.prodyna.dataprotection.navigator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents a Quiz.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class QuizItem implements Serializable {

    private int levelID;
    private int quizID;

    private Date startingTime;
    private Date finishedTime;

    public QuizItem() {
    }

    public QuizItem(int levelID, int quizID) {
        this.levelID = levelID;
        this.quizID = quizID;
        this.startingTime = new Date();
    }

    public QuizItem(int levelID, int quizID, Date startingTime, Date finishedTime) {
        this.levelID = levelID;
        this.quizID = quizID;
        this.startingTime = startingTime;
        this.finishedTime = finishedTime;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    @Override
    public String toString() {
        return "QuizItem{" +
                "levelID=" + levelID +
                ", quizID=" + quizID +
                ", startingTime=" + startingTime +
                ", finishedTime=" + finishedTime +
                '}';
    }
}
