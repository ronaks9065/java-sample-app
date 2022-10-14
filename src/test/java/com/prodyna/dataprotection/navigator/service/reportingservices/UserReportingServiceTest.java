package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.QuizItem;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.UserReportingDTO;
import com.prodyna.dataprotection.navigator.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class UserReportingServiceTest {
    private static final int USERS_IN_BASIC = 3;
    private static final int USERS_IN_ADVANCED = 5;
    private static final int USERS_IN_EXPERT = 7;
    private static final int USERS_TOTAL = USERS_IN_BASIC + USERS_IN_ADVANCED + USERS_IN_EXPERT;
    private UserService userService;
    private UserReportingService userReportingService;

    @Before
    public void setup() {
        userService = mock(UserService.class);
        userReportingService = new UserReportingService(0, 1000, userService);
    }

    @Test
    public void givenNoUsers_WhenGenerating_ThenDefaultValues() {
        doReturn(new ArrayList<User>()).when(userService).getAllUsers();

        UserReportingDTO userReporting = userReportingService.generateReport();

        testEmptyResult(userReporting);
    }

    private void testEmptyResult(UserReportingDTO userReporting) {
        assertEquals("There should be no User", 0, userReporting.getUniqueVisitors());
        assertEquals("There should be no Sessions", 0, userReporting.getBaseSessions());
        assertEquals("There should be no Sessions", 0, userReporting.getAdvancedSessions());
        assertEquals("There should be no Sessions", 0, userReporting.getExpertSessions());
        assertEquals("There should be no Sessions", 0, userReporting.getSessions());

    }

    @Test
    public void givenUsersOutOfTimeRange_WhenGenerating_ThenThoseAreNotIncluded() {
        List<User> userList = generateUserList();
        doReturn(userList).when(userService).getAllUsers();
        for (User user : userList) {
            user.getQuizes().get(0).setStartingTime(new Date(1500));
        }

        UserReportingDTO userReporting = userReportingService.generateReport();

        testEmptyResult(userReporting);
    }

    @Test
    public void givenUsers_WhenGenerating_ThenCorrectValues() {
        doReturn(generateUserList()).when(userService).getAllUsers();

        UserReportingDTO userReporting = userReportingService.generateReport();

        assertEquals("Incorrect amount of unique users", USERS_TOTAL, userReporting.getUniqueVisitors());
        assertEquals("Incorrect amount of Base Sessions", USERS_IN_BASIC, userReporting.getBaseSessions());
        assertEquals("Incorrect amount of Advanced Sessions", USERS_IN_ADVANCED, userReporting.getAdvancedSessions());
        assertEquals("Incorrect amount of Expert Sessions", USERS_IN_EXPERT, userReporting.getExpertSessions());
        assertEquals("Incorrect amount of all Sessions", USERS_TOTAL, userReporting.getSessions());
    }

    @Test
    public void givenUserStartsMultipleTimes_WhenGenerating_ThenOnlyCountOnce() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.addQuiz(new QuizItem(1, 0, new Date(200), new Date(300)));
        user.addQuiz(new QuizItem(2, 0, new Date(300), new Date(400)));
        userList.add(user);
        doReturn(userList).when(userService).getAllUsers();

        UserReportingDTO userReporting = userReportingService.generateReport();

        assertEquals("User should only be counted once", 1, userReporting.getUniqueVisitors());
        assertEquals("Sessions should add up for same User", 2, userReporting.getSessions());
    }

    private List<User> generateUserList() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < USERS_IN_BASIC; i++) {
            userList.add(generateUser(1));
        }
        for (int i = 0; i < USERS_IN_ADVANCED; i++) {
            userList.add(generateUser(2));
        }
        for (int i = 0; i < USERS_IN_EXPERT; i++) {
            userList.add(generateUser(4));
        }
        return userList;
    }

    private User generateUser(int level) {
        User user = new User();
        QuizItem quizItem = new QuizItem(level, 0, new Date(500), new Date(1500));
        user.addQuiz(quizItem);
        return user;
    }
}
