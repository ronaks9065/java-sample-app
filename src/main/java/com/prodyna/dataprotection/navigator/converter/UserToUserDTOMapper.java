package com.prodyna.dataprotection.navigator.converter;

import com.prodyna.dataprotection.navigator.model.QuizItem;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.UserDTO;

import javax.inject.Named;

/**
 * Maps the user information to userDTO (current UserProgress) and vice versa for data transfer purposes.
 */
@Named
public class UserToUserDTOMapper implements Mapper<User, UserDTO> {

    @Override
    public UserDTO mapTo(User input) {
        UserDTO userDTO = new UserDTO();
        int maxLevel = 1;
        for (QuizItem quiz : input.getQuizes()) {
            if (quiz.getFinishedTime() != null) {
                switch (quiz.getLevelID()) {
                    case 1:
                        userDTO.addProgressedBasic(quiz.getQuizID());
                        break;
                    case 2:
                        userDTO.addProgressedAdvanced(quiz.getQuizID());
                        maxLevel = Math.max(maxLevel, 2);
                        break;
                    case 4:
                        userDTO.addProgressedLeader(quiz.getQuizID());
                        maxLevel = 4;
                        break;
                }
            }
        }
        userDTO.setSelectedLevel(maxLevel);
        userDTO.setCurrentQuiz("quiz" + 0);
        return userDTO;
    }

    @Override
    public User mapFrom(UserDTO input) {
        return null;
    }
}
