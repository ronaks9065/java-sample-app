package com.prodyna.dataprotection.navigator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a User DTO
 */
@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO implements Serializable {

    private int selectedLevel;

    private String currentQuiz;

    private List<Integer> progressedBasic = new ArrayList<>();
    private List<Integer> progressedAdvanced = new ArrayList<>();
    private List<Integer> progressedLeader = new ArrayList<>();

    public UserDTO() {
    }

    public List<Integer> getProgressedLeader() {
        return progressedLeader;
    }

    public void setProgressedLeader(List<Integer> progressedLeader) {
        this.progressedLeader = progressedLeader;
    }

    /**
     * @param progressedLeader A quiz id of the level ProgressLeader
     * @see com.prodyna.dataprotection.navigator.converter.UserToUserDTOMapper
     */
    public void addProgressedLeader(Integer progressedLeader) {
        this.progressedLeader.add(progressedLeader);
    }

    public int getSelectedLevel() {
        return selectedLevel;
    }

    public void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }

    public List<Integer> getProgressedBasic() {
        return progressedBasic;
    }

    public void setProgressedBasic(List<Integer> progressedBasic) {
        this.progressedBasic = new ArrayList<>(progressedBasic);
    }

    /**
     * @param prgressBasic A quiz id of the level ProgressBasic
     * @see com.prodyna.dataprotection.navigator.converter.UserToUserDTOMapper
     */
    public void addProgressedBasic(Integer prgressBasic) {
        this.progressedBasic.add(prgressBasic);
    }

    public List<Integer> getProgressedAdvanced() {
        return progressedAdvanced;
    }

    public void setProgressedAdvanced(List<Integer> progressedAdvanced) {
        this.progressedAdvanced = new ArrayList<>(progressedAdvanced);
    }

    /**
     * @param progressAdvanced A quiz id of the level progressAdvanced
     * @see com.prodyna.dataprotection.navigator.converter.UserToUserDTOMapper
     */
    public void addProgressedAdvanced(Integer progressAdvanced) {
        this.progressedAdvanced.add(progressAdvanced);
    }

    public void setCurrentQuiz(String currentQuiz) {
        this.currentQuiz = currentQuiz;
    }

    public String getQuizId() {
        return this.currentQuiz;
    }

    public int getIntQuizId() {
        return Integer.parseInt(this.currentQuiz.substring(4));
    }


    @Override
    public String toString() {
        return "DSNUser{" +
                "selectedLevel=" + selectedLevel +
                ", currentQuiz='" + currentQuiz + '\'' +
                ", progressedBasic=" + progressedBasic +
                ", progressedAdvanced=" + progressedAdvanced +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDTO dsnUser = (UserDTO) o;
        return selectedLevel == dsnUser.selectedLevel &&
                Objects.equals(currentQuiz, dsnUser.currentQuiz) &&
                Objects.equals(progressedBasic, dsnUser.progressedBasic) &&
                Objects.equals(progressedAdvanced, dsnUser.progressedAdvanced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectedLevel, currentQuiz, progressedBasic, progressedAdvanced);
    }
}
