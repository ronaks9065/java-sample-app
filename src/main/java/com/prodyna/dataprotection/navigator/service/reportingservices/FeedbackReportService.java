package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.Feedback;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.FeedbackReportDTO;
import com.prodyna.dataprotection.navigator.model.reporting.FeedbackReportLineDTO;
import com.prodyna.dataprotection.navigator.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for generating feedback report.
 */
public class FeedbackReportService implements ReportingService {

    private final long from;
    private final long to;

    private final UserService userService;

    public FeedbackReportService(long from, long to, UserService userService) {
        this.from = from;
        this.to = to;
        this.userService = userService;
    }

    /**
     * Generates feedbackData for Report for the time between from and to.
     *
     * @return FeedbackReportDTO
     */
    @Override
    public FeedbackReportDTO generateReport() {
        FeedbackReportDTO feedbackReportDTO = new FeedbackReportDTO();
        List<User> userList = userService.getAllUsers();
        List<Feedback> feedbacks = userList.stream().filter(user -> user.getFeedback() != null).map(User::getFeedback)
                .filter(feedback -> GeneralReportingService.isDateBetween(feedback.getDate(), from, to))
                .collect(Collectors.toList());
        for (int i = 0; i < feedbacks.size(); i++) {
            Feedback feedback = feedbacks.get(i);
            feedbackReportDTO.addFeedbackLine(new FeedbackReportLineDTO(i + 1, feedback.getScore(), feedback.getComment()));
        }
        feedbackReportDTO.setOneStar(getStarCount(1, feedbackReportDTO));
        feedbackReportDTO.setTwoStars(getStarCount(2, feedbackReportDTO));
        feedbackReportDTO.setThreeStars(getStarCount(3, feedbackReportDTO));
        feedbackReportDTO.setFourStars(getStarCount(4, feedbackReportDTO));
        feedbackReportDTO.setFiveStars(getStarCount(5, feedbackReportDTO));
        return feedbackReportDTO;
    }

    private long getStarCount(int star, FeedbackReportDTO feedbackReport) {
        return feedbackReport.getFeedbackLines().stream().filter(f -> f.getStars() == star).count();
    }
}
