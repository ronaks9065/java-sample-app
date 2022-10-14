package com.prodyna.dataprotection.navigator.service;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.user.ConfluenceUser;
import com.atlassian.sal.api.user.UserKey;
import com.prodyna.dataprotection.navigator.model.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class UserServiceTest {
    private BandanaManager bandanaManager;
    private UserService userService;
    private ConfluenceUser confluenceUser;
    private UserDTO userDTO;

    @Before
    public void setup() {
        bandanaManager = mock(BandanaManager.class);
        userService = new UserService(bandanaManager);

        confluenceUser = mock(ConfluenceUser.class);
        doReturn(new UserKey("")).when(confluenceUser).getKey();

        userDTO = new UserDTO();
        userDTO.setCurrentQuiz("quiz0");
        userDTO.setSelectedLevel(1);
    }

    @Test
    public void givenUserNotExistent_WhenGettingUser_ThenNewUserIsCreated() throws IOException {
        User user = userService.getUserById("userId");
        verify(bandanaManager, times(1)).setValue(any(BandanaContext.class), anyString(), eq(new ObjectMapper().writeValueAsString(user)));
    }

    @Test
    public void givenUserNotExistent_WhenCreatingNewUser_ThenUserIDIsHashed() {
        String userId = "userId";
        User user = userService.getUserById(userId);

        assertNotEquals("UserId should have changed", userId, user.getUserId());
        assertNotEquals("UserId should have changed", userId.hashCode(), user.getUserId());

    }

    @Test
    public void givenUserHasNotStartedQuiz_WhenQuizStart_ThenNewQuizItemCreated() throws IOException {
        User user = new User();

        assertEquals("User should not have a QuizItem", 0, user.getQuizes().size());

        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());
        user = userService.startQuizForUser(userDTO, confluenceUser);

        assertEquals("User should have a new QuizItem", 1, user.getQuizes().size());
    }

    @Test
    public void givenUserHasStartedQuiz_WhenQuizStart_ThenStartTimeIsUpdated() throws IOException {
        User user = new User();

        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.startQuizForUser(userDTO, confluenceUser);
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() - 60 * 1000);
        user.getQuizes().get(0).setStartingTime(startDate);
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());
        user = userService.startQuizForUser(userDTO, confluenceUser);

        assertNotEquals("Timestamp should have changed", startDate, user.getQuizes().get(0).getStartingTime());
    }

    @Test
    public void givenUserHasFinishedQuiz_WhenQuizStart_ThenStartTimeIsNotUpdated() throws IOException {
        User user = new User();

        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.startQuizForUser(userDTO, confluenceUser);
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() - 60 * 1000);
        user.getQuizes().get(0).setStartingTime(startDate);
        user.getQuizes().get(0).setFinishedTime(new Date());
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());
        user = userService.startQuizForUser(userDTO, confluenceUser);

        assertEquals("Timestamp should not have changed", startDate, user.getQuizes().get(0).getStartingTime());
    }

    @Test
    public void givenUserHasStartedDifferentQuiz_WhenQuizStart_ThenQuizAmountIncremented() throws IOException {
        User user = new User();
        user.addQuiz(new QuizItem(2, 0));

        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.startQuizForUser(userDTO, confluenceUser);

        assertEquals("User should have a new QuizItem", 2, user.getQuizes().size());
    }

    @Test
    public void givenExistingUsers_WhenGettingUserlist_ThenSuccess() throws IOException {
        String userKey = "Users_Key";
        List<String> keys = new ArrayList<>(Arrays.asList(userKey, "differentKey"));
        doReturn(keys).when(bandanaManager).getKeys(any(BandanaContext.class));
        doReturn(new ObjectMapper().writeValueAsString(new User())).when(bandanaManager).getValue(any(BandanaContext.class), eq(userKey));

        assertEquals("Userlist should have one Element", 1, userService.getAllUsers().size());
    }

    @Test
    public void givenNoUsers_WhenGettingUserlist_ThenEmptyList() {
        List<String> keys = new ArrayList<>(Arrays.asList("key1", "key2"));
        doReturn(keys).when(bandanaManager).getKeys(any(BandanaContext.class));

        assertTrue("Userlist should be empty", userService.getAllUsers().isEmpty());
    }

    @Test
    public void givenNoQuizStarted_WhenFinishingQuiz_ThenNothing() {
        User user = new User();
        doReturn(user).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.finishQuizForUser(userDTO, confluenceUser);

        assertTrue("QuizList should not have changed", user.getQuizes().isEmpty());
    }

    @Test
    public void givenQuizStarted_WhenFinishingQuiz_ThenFinishedTimeSet() throws IOException {
        User user = new User();
        user.addQuiz(new QuizItem(1, 0));
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.finishQuizForUser(userDTO, confluenceUser);

        assertFalse("QuizList should have changed", user.getQuizes().isEmpty());
        assertNotNull("FinishedTime should be set", user.getQuizes().get(0).getFinishedTime());
    }

    @Test
    public void givenQuizFinished_WhenFinishingQuiz_ThenNothing() throws IOException {
        User user = new User();
        user.addQuiz(new QuizItem(1, 0, new Date(), new Date()));
        Date finishedDate = new Date();
        user.getQuizes().get(0).setFinishedTime(finishedDate);
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.finishQuizForUser(userDTO, confluenceUser);

        assertFalse("QuizList should have changed", user.getQuizes().isEmpty());
        assertEquals("FinishedTime should not have changed", finishedDate, user.getQuizes().get(0).getFinishedTime());
    }

    @Test
    public void givenOtherQuizFinished_WhenFinishingQuiz_ThenNewFinishedQuiz() throws IOException {
        User user = new User();
        user.addQuiz(new QuizItem(2, 0, new Date(), new Date()));
        user.addQuiz(new QuizItem(1, 0));
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.finishQuizForUser(userDTO, confluenceUser);

        assertEquals("QuizList should have changed", 2, user.getQuizes().size());
        assertNotNull("FinishedTime should have been set", user.getQuizes().get(1).getFinishedTime());
    }

    @Test
    public void givenUserAccesses_WhenAddingAccess_ThenAccessIsAdded() {
        User user = new User();

        userService.updateUser(user, DeviceType.DESKTOP);

        assertEquals("User should have accessEntry", 1L, user.getAccessEntries().size());
        assertEquals("User should have accessEntry with Desktop", DeviceType.DESKTOP, user.getAccessEntries().get(0).getAccessDevice());

    }

    @Test
    public void givenNoFeedback_WhenAddingFeedback_ThenFeedbackIsAdded() throws IOException {
        User user = new User();
        user.setUserId("userId");
        Feedback feedback = new Feedback();
        feedback.setScore(1);
        feedback.setComment("Comment");
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.setFeedbackFromUser(feedback, user.getUserId());

        assertEquals("Feedback should be set", feedback, user.getFeedback());
    }

    @Test
    public void givenFeedback_WhenAddingFeedback_ThenNothing() throws IOException {
        User user = new User();
        user.setUserId("userId");
        Feedback feedback1 = new Feedback();
        feedback1.setScore(1);
        feedback1.setComment("Comment");
        Feedback feedback2 = new Feedback();
        feedback2.setScore(2);
        feedback2.setComment("Comment2");
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());

        user = userService.setFeedbackFromUser(feedback1, user.getUserId());
        doReturn(new ObjectMapper().writeValueAsString(user)).when(bandanaManager).getValue(any(BandanaContext.class), anyString());
        user = userService.setFeedbackFromUser(feedback2, user.getUserId());

        assertEquals("Feedback should not have changed", feedback1, user.getFeedback());
    }
}
