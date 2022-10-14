package com.prodyna.dataprotection.navigator.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * One Answer for the Quiz.
 */
@XmlRootElement(name = "Question")
@XmlAccessorType(XmlAccessType.FIELD)
class Answer {

    // The answer text that is shown to the user.
    private String answerText;

    // true, if the answer is correct.
    private boolean correct;

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
