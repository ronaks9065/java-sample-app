package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.reporting.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

import static com.prodyna.dataprotection.navigator.service.reportingservices.ReportingServices.*;

@Named
public class GeneralReportingService {

    private final ReportingServiceFactory reportingServiceFactory;

    @Inject
    public GeneralReportingService(ReportingServiceFactory reportingServiceFactory) {
        this.reportingServiceFactory = reportingServiceFactory;
    }

    /**
     * Decides if a date is between two times (excluding the time itself)
     *
     * @param date The date to test
     * @param from beginning as Unix Timestamp in milliseconds
     * @param to   end  as Unix Timestamp in milliseconds
     * @return true if the date is between
     */
    public static boolean isDateBetween(Date date, long from, long to) {
        if (date == null) {
            return false;
        }
        return date.getTime() > from && date.getTime() < to;
    }

    /**
     * Decides if any of the given dates is between two times (excluding the time itself)
     *
     * @param firstDate  The first Date to test
     * @param secondDate The second Date to test
     * @param from       beginning as Unix Timestamp in milliseconds
     * @param to         end  as Unix Timestamp in milliseconds
     * @return true if any date is between
     */
    public static boolean isAnyDateBetween(Date firstDate, Date secondDate, long from, long to) {
        return isDateBetween(firstDate, from, to) || isDateBetween(secondDate, from, to);
    }

    /**
     * Decides if both of the given dates are between two times (excluding the time itself)
     *
     * @param firstDate  The first Date to test
     * @param secondDate The second Date to test
     * @param from       beginning as Unix Timestamp in milliseconds
     * @param to         end  as Unix Timestamp in milliseconds
     * @return true if both dates are between
     */
    public static boolean isAllDateBetween(Date firstDate, Date secondDate, long from, long to) {
        return isDateBetween(firstDate, from, to) && isDateBetween(secondDate, from, to);
    }

    /**
     * Delegates the reporting functionality to the UserReportingService
     *
     * @param from beginning as Unix Timestamp in milliseconds
     * @param to   end as Unix Timestamp in milliseconds
     * @return Returns the UserReportingData
     */
    public UserReportingDTO getUserReporting(long from, long to) {
        UserReportingService userReportingService = (UserReportingService) reportingServiceFactory.getReportingService(from, to, USER);
        return userReportingService.generateReport();
    }

    /**
     * Delegates the reporting functionality to the QuizFinishingsReportService
     *
     * @param from beginning as Unix Timestamp in milliseconds
     * @param to   end as Unix Timestamp in milliseconds
     * @return Returns the FinishingsData
     */
    public QuizFinishingsReportDTO getQuizFinishingReport(long from, long to) {
        FinishingsReportService finishingsReportService = (FinishingsReportService) reportingServiceFactory.getReportingService(from, to, FINISHINGS);
        return finishingsReportService.generateReport();
    }

    /**
     * Delegates the reporting functionality to the SourceReportingService
     *
     * @param from beginning as Unix Timestamp in milliseconds
     * @param to   end as Unix Timestamp in milliseconds
     * @return Returns the SourceReportingData
     */
    public SourceReportDTO getSourceReport(long from, long to) {
        SourceReportService sourceReportService = (SourceReportService) reportingServiceFactory.getReportingService(from, to, SOURCE);
        return sourceReportService.generateReport();
    }

    /**
     * Delegates the reporting functionality to the FeedbackReportingService
     *
     * @param from beginning as Unix Timestamp in milliseconds
     * @param to   end as Unix Timestamp in milliseconds
     * @return Returns the FeedbackReportingData
     */
    public FeedbackReportDTO getFeedbackReport(long from, long to) {
        FeedbackReportService feedbackReportService = (FeedbackReportService) reportingServiceFactory.getReportingService(from, to, FEEDBACK);
        return feedbackReportService.generateReport();
    }

    /**
     * Delegates the reporting functionality to the TimeRequiredReportingService
     *
     * @param from beginning as Unix Timestamp in milliseconds
     * @param to   end as Unix Timestamp in milliseconds
     * @return Returns the TimeRequiredReportingData
     */
    public TimeRequiredReportingDTO getTimeRequiredReport(long from, long to) {
        TimeRequiredReportService timeRequiredReportService = (TimeRequiredReportService) reportingServiceFactory.getReportingService(from, to, TIMEREQUIRED);
        return timeRequiredReportService.generateReport();

    }
}
