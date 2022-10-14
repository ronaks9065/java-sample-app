package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.QuizItem;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.TimeRequiredLineDTO;
import com.prodyna.dataprotection.navigator.model.reporting.TimeRequiredReportingDTO;
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
public class TimeRequiredReportingServiceTest {
    private UserService userService;
    private TimeRequiredReportService timeRequiredReportService;

    @Before
    public void setup() {
        userService = mock(UserService.class);
        timeRequiredReportService = new TimeRequiredReportService(0, 1000, userService);
    }

    @Test
    public void givenNoUser_WhenGenerating_ThenDefaultValues() {
        List<User> userList = new ArrayList<>();
        doReturn(userList).when(userService).getAllUsers();

        TimeRequiredReportingDTO timeRequiredReporting = timeRequiredReportService.generateReport();

        assertEquals("Default value should have been returned", generateDefaultReport(), timeRequiredReporting);
    }

    @Test
    public void givenUsersOutOfTimeRange_WhenGenerating_ThenThoseAreNotIncluded() {
        List<User> userList = generateUserList();
        for (User user : userList) {
            user.getQuizes().forEach(quiz -> {
                quiz.setStartingTime(new Date(1500));
                quiz.setFinishedTime(new Date(1500));
            });
        }
        doReturn(userList).when(userService).getAllUsers();

        TimeRequiredReportingDTO timeRequiredReporting = timeRequiredReportService.generateReport();

        assertEquals("Default value should have been returned", generateDefaultReport(), timeRequiredReporting);
    }

    @Test
    public void givenUsers_WhenGenerating_ThenCorrectValues() {
        List<User> userList = generateUserList();
        doReturn(userList).when(userService).getAllUsers();

        TimeRequiredReportingDTO timeRequiredReporting = timeRequiredReportService.generateReport();

        assertEquals("Default value should have been returned", generateFullReport(), timeRequiredReporting);
    }

    private TimeRequiredReportingDTO generateDefaultReport() {
        TimeRequiredReportingDTO timeRequiredReporting = new TimeRequiredReportingDTO();
        timeRequiredReporting.setTimesRequiredForBase(generateDefaultTimeRequiredLinesForLevel(1));
        timeRequiredReporting.setTimesRequiredForAdvanced(generateDefaultTimeRequiredLinesForLevel(2));
        timeRequiredReporting.setTimesRequiredForExpert(generateDefaultTimeRequiredLinesForLevel(4));
        return timeRequiredReporting;
    }

    private List<TimeRequiredLineDTO> generateDefaultTimeRequiredLinesForLevel(int level) {
        int max = level == 4 ? 7 : 13;
        List<TimeRequiredLineDTO> timeRequiredLines = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            timeRequiredLines.add(generateDefaultTimeRequiredLine(i));
        }
        return timeRequiredLines;
    }

    private TimeRequiredLineDTO generateDefaultTimeRequiredLine(int number) {
        TimeRequiredLineDTO timeRequiredLine = new TimeRequiredLineDTO();
        timeRequiredLine.setQuizName("quiz" + number);
        timeRequiredLine.setAccessedAmount(0L);
        timeRequiredLine.setFinishedAmount(0L);
        timeRequiredLine.setMinimumTime(0L);
        timeRequiredLine.setMaximumTime(0L);
        timeRequiredLine.setAverageTime(0.0);
        return timeRequiredLine;
    }

    private List<User> generateUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(generateUser(1));
        userList.add(generateUser(2));
        userList.add(generateUser(4));
        return userList;
    }

    private User generateUser(int level) {
        int max = level == 4 ? 7 : 13;
        User user = new User();
        for (int i = 0; i < max; i++) {
            user.addQuiz(new QuizItem(level, i, new Date(250), new Date(750)));
        }
        return user;
    }

    private TimeRequiredReportingDTO generateFullReport() {
        TimeRequiredReportingDTO timeRequiredReporting = new TimeRequiredReportingDTO();
        timeRequiredReporting.setTimesRequiredForBase(generateFullTimeRequiredLinesForLevel(1));
        timeRequiredReporting.setTimesRequiredForAdvanced(generateFullTimeRequiredLinesForLevel(2));
        timeRequiredReporting.setTimesRequiredForExpert(generateFullTimeRequiredLinesForLevel(4));
        return timeRequiredReporting;
    }

    private List<TimeRequiredLineDTO> generateFullTimeRequiredLinesForLevel(int level) {
        int max = level == 4 ? 7 : 13;
        List<TimeRequiredLineDTO> timeRequiredLines = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            timeRequiredLines.add(generateFullTimeRequiredLine(i));
        }
        return timeRequiredLines;
    }

    private TimeRequiredLineDTO generateFullTimeRequiredLine(int number) {
        TimeRequiredLineDTO timeRequiredLine = new TimeRequiredLineDTO();
        timeRequiredLine.setQuizName("quiz" + number);
        timeRequiredLine.setAccessedAmount(1L);
        timeRequiredLine.setFinishedAmount(1L);
        timeRequiredLine.setMinimumTime(0L);
        timeRequiredLine.setMaximumTime(0L);
        timeRequiredLine.setAverageTime(0.5);
        return timeRequiredLine;
    }

}
