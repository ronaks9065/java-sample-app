package com.prodyna.dataprotection.navigator.converter;

import com.prodyna.dataprotection.navigator.model.QuizItem;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UserToUserDTOMapperTest {

    private static final String LIST_SHOULD_BE_EMPTY = "List should be empty";

    @Test
    public void givenUserFinishedNoQuiz_WhenMapping_ThenFinishedListIsEmpty() {
        UserToUserDTOMapper userToUserDTOMapper = new UserToUserDTOMapper();
        User user = new User();

        UserDTO userDTO = userToUserDTOMapper.mapTo(user);

        assertTrue(LIST_SHOULD_BE_EMPTY, userDTO.getProgressedBasic().isEmpty());
        assertTrue(LIST_SHOULD_BE_EMPTY, userDTO.getProgressedAdvanced().isEmpty());
        assertTrue(LIST_SHOULD_BE_EMPTY, userDTO.getProgressedLeader().isEmpty());
    }

    @Test
    public void givenUserFinishedLvl1Quiz_WhenMapping_ThenBasicListNotEmpty() {
        UserToUserDTOMapper userToUserDTOMapper = new UserToUserDTOMapper();
        User user = new User();
        QuizItem quizItem = new QuizItem(1, 1);
        quizItem.setFinishedTime(new Date());
        user.addQuiz(quizItem);

        UserDTO userDTO = userToUserDTOMapper.mapTo(user);

        assertFalse("List should not be empty", userDTO.getProgressedBasic().isEmpty());
        assertEquals("First Quiz should be finished", (Integer) 1, userDTO.getProgressedBasic().get(0));
        assertTrue(LIST_SHOULD_BE_EMPTY, userDTO.getProgressedAdvanced().isEmpty());
        assertTrue(LIST_SHOULD_BE_EMPTY, userDTO.getProgressedLeader().isEmpty());
    }

    @Test
    public void givenUserFinishedLvl1Quiz_WhenMapping_ThenCurrentLevelStays1() {
        UserToUserDTOMapper userToUserDTOMapper = new UserToUserDTOMapper();
        User user = new User();
        user.addQuiz(new QuizItem(1, 1, new Date(), new Date()));

        UserDTO userDTO = userToUserDTOMapper.mapTo(user);

        assertEquals("Selected Level should stay 1", 1, userDTO.getSelectedLevel());
    }

    @Test
    public void givenUserFinishedLvl2Quiz_WhenMapping_ThenCurrentLevelBecomes2() {
        UserToUserDTOMapper userToUserDTOMapper = new UserToUserDTOMapper();
        User user = new User();
        user.addQuiz(new QuizItem(2, 1, new Date(), new Date()));

        UserDTO userDTO = userToUserDTOMapper.mapTo(user);

        assertEquals("Selected Level should become 2", 2, userDTO.getSelectedLevel());
    }

    @Test
    public void givenUserFinishedLvl4Quiz_WhenMapping_ThenCurrentLevelBecome4() {
        UserToUserDTOMapper userToUserDTOMapper = new UserToUserDTOMapper();
        User user = new User();
        user.addQuiz(new QuizItem(4, 1, new Date(), new Date()));

        UserDTO userDTO = userToUserDTOMapper.mapTo(user);

        assertEquals("Selected Level should become 4", 4, userDTO.getSelectedLevel());
    }

    @Test
    public void givenUserFinishedMultipleQuizes_WhenMapping_ThenCurrentLevelBecomesMax() {
        UserToUserDTOMapper userToUserDTOMapper = new UserToUserDTOMapper();
        User user = new User();
        user.addQuiz(new QuizItem(4, 1, new Date(), new Date()));
        user.addQuiz(new QuizItem(2, 1, new Date(), new Date()));
        user.addQuiz(new QuizItem(1, 1, new Date(), new Date()));

        UserDTO userDTO = userToUserDTOMapper.mapTo(user);

        assertEquals("Selected Level should become maximum of them (4)", 4, userDTO.getSelectedLevel());
    }

    @Test
    public void givenUser_WhenMappingBack_ThenNothingIsReturned() {
        UserToUserDTOMapper userToUserDTOMapper = new UserToUserDTOMapper();
        UserDTO userDTO = new UserDTO();

        assertNull("Mapping from UserDTO to User should not be possible", userToUserDTOMapper.mapFrom(userDTO));
    }

}
