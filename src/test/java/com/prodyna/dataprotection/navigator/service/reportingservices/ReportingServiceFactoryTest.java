package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.prodyna.dataprotection.navigator.service.reportingservices.ReportingServices.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class ReportingServiceFactoryTest {
    @Test
    public void givenServiceEnum_WhenGettingService_ThenCorrectServiceIsReturned() {
        ReportingServiceFactory reportingServiceFactory = new ReportingServiceFactory(mock(UserService.class));

        assertEquals("Service has wrong type", UserReportingService.class, reportingServiceFactory.getReportingService(0, 0, USER).getClass());
        assertEquals("Service has wrong type", FinishingsReportService.class, reportingServiceFactory.getReportingService(0, 0, FINISHINGS).getClass());
        assertEquals("Service has wrong type", SourceReportService.class, reportingServiceFactory.getReportingService(0, 0, SOURCE).getClass());
        assertEquals("Service has wrong type", FeedbackReportService.class, reportingServiceFactory.getReportingService(0, 0, FEEDBACK).getClass());
        assertEquals("Service has wrong type", TimeRequiredReportService.class, reportingServiceFactory.getReportingService(0, 0, TIMEREQUIRED).getClass());
    }
}
