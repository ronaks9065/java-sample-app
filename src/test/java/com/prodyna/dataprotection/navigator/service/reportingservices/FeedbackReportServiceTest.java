package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.Feedback;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.FeedbackReportDTO;
import com.prodyna.dataprotection.navigator.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class FeedbackReportServiceTest {
    private UserService userService;
    private FeedbackReportService feedbackReportService;

    @Before
    public void setup() {
        userService = mock(UserService.class);
        feedbackReportService = new FeedbackReportService(0, 1000, userService);
    }

    @Test
    public void givenNoUser_WhenGeneratingFeedback_ThenDefualtValuesReturned() {
        doReturn(new ArrayList<User>()).when(userService).getAllUsers();

        FeedbackReportDTO feedbackReport = feedbackReportService.generateReport();

        assertEmptyFeedback(feedbackReport);
    }

    private void assertEmptyFeedback(FeedbackReportDTO feedbackReport) {
        assertTrue("There should be no feedbackLines", feedbackReport.getFeedbackLines().isEmpty());
        assertEquals("There should be no stars", 0, feedbackReport.getOneStar());
        assertEquals("There should be no stars", 0, feedbackReport.getTwoStars());
        assertEquals("There should be no stars", 0, feedbackReport.getThreeStars());
        assertEquals("There should be no stars", 0, feedbackReport.getFourStars());
        assertEquals("There should be no stars", 0, feedbackReport.getFiveStars());
    }

    @Test
    public void givenFeedbacksOutOfTimerange_WhenGeneratingFeedback_ThenTheseFeedbacksAreNotIncluded() {
        User user = new User();
        user.setFeedback(new Feedback(1, "Comment", new Date(2000)));
        List<User> userList = new ArrayList<>();
        userList.add(user);
        doReturn(userList).when(userService).getAllUsers();

        FeedbackReportDTO feedbackReport = feedbackReportService.generateReport();

        assertEmptyFeedback(feedbackReport);
    }

    @Test
    public void givenFeedback_WhenGeneratingFeedback_ThenAllEntriesAreCorrect() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            for (int o = 0; o < i; o++) {
                userList.add(generateUserFeedback(i));
            }
        }
        doReturn(userList).when(userService).getAllUsers();

        FeedbackReportDTO feedbackReport = feedbackReportService.generateReport();

        assertEquals("FeedbackReport has wrong amount of entries", 15, feedbackReport.getFeedbackLines().size());
        assertEquals("FeedbackReport has wrong number of Starts", 1, feedbackReport.getOneStar());
        assertEquals("FeedbackReport has wrong number of Starts", 2, feedbackReport.getTwoStars());
        assertEquals("FeedbackReport has wrong number of Starts", 3, feedbackReport.getThreeStars());
        assertEquals("FeedbackReport has wrong number of Starts", 4, feedbackReport.getFourStars());
        assertEquals("FeedbackReport has wrong number of Starts", 5, feedbackReport.getFiveStars());
        for (int i = 0; i < 15; i++) {
            assertEquals("Id is wrong", i + 1, feedbackReport.getFeedbackLines().get(i).getId());
        }
    }

    private User generateUserFeedback(int score) {
        User user = new User();
        user.setFeedback(new Feedback(score, "Comment" + score, new Date(500)));
        return user;
    }
}
