package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.QuizItem;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.QuizFinishingsReportDTO;
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
public class FinishingsReportServiceTest {
    private UserService userService;
    private FinishingsReportService finishingsReportService;

    @Before
    public void setup() {
        userService = mock(UserService.class);
        finishingsReportService = new FinishingsReportService(0, 1000, userService);
    }

    @Test
    public void givenNoUser_WhenGenerating_ThenDefaultValues() {
        doReturn(new ArrayList<User>()).when(userService).getAllUsers();

        QuizFinishingsReportDTO quizFinishingsReport = finishingsReportService.generateReport();

        assertEquals("Default Values should have been returned", generateDefaultReport(), quizFinishingsReport);
    }

    private QuizFinishingsReportDTO generateDefaultReport() {
        QuizFinishingsReportDTO quizFinishingsReport = new QuizFinishingsReportDTO();
        quizFinishingsReport.setAllCertificatsReceived(0L);

        quizFinishingsReport.setBaseCertificatesReceived(0L);
        quizFinishingsReport.setBaseResultsSum(0L);
        quizFinishingsReport.setBaseResults(generateResults(13, 0L));

        quizFinishingsReport.setAdvancedCertificatesReceived(0L);
        quizFinishingsReport.setAdvancedResultsSum(0L);
        quizFinishingsReport.setAdvancedResults(generateResults(13, 0L));

        quizFinishingsReport.setExpertCertificatesReceived(0L);
        quizFinishingsReport.setExpertResultsSum(0L);
        quizFinishingsReport.setExpertResults(generateResults(7, 0L));
        return quizFinishingsReport;
    }

    private List<Long> generateResults(int number, Long value) {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            results.add(value);
        }
        return results;
    }

    @Test
    public void givenUsersOutOfTimeRange_WhenGenerating_ThenThoseAreNotIncluded() {
        List<User> userList = generateUserList();
        for (User user : userList) {
            user.getQuizes().forEach(quiz -> quiz.setFinishedTime(new Date(1500)));
            if (user.getBasicCertificateAccessed() != null) {
                user.setBasicCertificateAccessed(new Date(1500));
            }
            if (user.getAdvancedCertificateAccessed() != null) {
                user.setAdvancedCertificateAccessed(new Date(1500));
            }
            if (user.getExpertCertificateAccessed() != null) {
                user.setExpertCertificateAccessed(new Date(1500));
            }
        }
        doReturn(userList).when(userService).getAllUsers();

        QuizFinishingsReportDTO quizFinishingsReport = finishingsReportService.generateReport();

        assertEquals("Default values should have been returned", generateDefaultReport(), quizFinishingsReport);

    }

    private List<User> generateUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(generateUserForLevel(1));
        userList.add(generateUserForLevel(2));
        userList.add(generateUserForLevel(4));

        return userList;
    }

    private User generateUserForLevel(int level) {
        User user = new User();
        int max = level == 4 ? 7 : 13;
        for (int i = 0; i < max; i++) {
            user.addQuiz(new QuizItem(level, i, new Date(250), new Date(750)));
        }
        switch (level) {
            case 1:
                user.setBasicCertificateAccessed(new Date(800));
                break;
            case 2:
                user.setAdvancedCertificateAccessed(new Date(800));
                break;
            case 4:
                user.setExpertCertificateAccessed(new Date(800));
                break;
        }
        return user;
    }

    @Test
    public void givenUsers_WhenGenerating_ThenCorrectValues() {
        List<User> userList = generateUserList();
        doReturn(userList).when(userService).getAllUsers();

        QuizFinishingsReportDTO quizFinishingsReport = finishingsReportService.generateReport();

        assertEquals("Full values should have been returned", generateFullReport(), quizFinishingsReport);
    }

    private QuizFinishingsReportDTO generateFullReport() {
        QuizFinishingsReportDTO quizFinishingsReport = new QuizFinishingsReportDTO();
        quizFinishingsReport.setAllCertificatsReceived(3L);

        quizFinishingsReport.setBaseCertificatesReceived(1L);
        quizFinishingsReport.setBaseResultsSum(13L);
        quizFinishingsReport.setBaseResults(generateResults(13, 1L));

        quizFinishingsReport.setAdvancedCertificatesReceived(1L);
        quizFinishingsReport.setAdvancedResultsSum(13L);
        quizFinishingsReport.setAdvancedResults(generateResults(13, 1L));

        quizFinishingsReport.setExpertCertificatesReceived(1L);
        quizFinishingsReport.setExpertResultsSum(7L);
        quizFinishingsReport.setExpertResults(generateResults(7, 1L));

        return quizFinishingsReport;
    }
}