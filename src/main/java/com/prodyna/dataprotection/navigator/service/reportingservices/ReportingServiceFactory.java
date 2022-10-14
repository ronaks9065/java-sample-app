package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.service.UserService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
class ReportingServiceFactory {

    private final UserService userService;

    @Inject
    public ReportingServiceFactory(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns a new instance of a ReportingService based on the type
     *
     * @param from beginning of the Reporting period as Unix Timestamp in milliseconds
     * @param to   end of the Reporting Period as Unix Timestamp in milliseconds
     * @param type the type of ReportingService needed
     * @return Returns a new instance of a ReportingService with the correct type
     */
    public ReportingService getReportingService(long from, long to, ReportingServices type) {
        switch (type) {
            case USER:
                return new UserReportingService(from, to, userService);
            case FINISHINGS:
                return new FinishingsReportService(from, to, userService);
            case TIMEREQUIRED:
                return new TimeRequiredReportService(from, to, userService);
            case SOURCE:
                return new SourceReportService(from, to, userService);
            case FEEDBACK:
                return new FeedbackReportService(from, to, userService);
        }
        return null;
    }
}
