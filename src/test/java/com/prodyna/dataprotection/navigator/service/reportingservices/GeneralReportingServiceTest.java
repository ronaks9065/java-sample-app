package com.prodyna.dataprotection.navigator.service.reportingservices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class GeneralReportingServiceTest {
    private final int from = 1000;
    private final int to = 2000;

    @Test
    public void givenNoDate_WhenCheckingDate_ThenFailure() {
        assertFalse("There is no date -> should be failure", GeneralReportingService.isDateBetween(null, from, to));
    }

    @Test
    public void givenDateBefore_WhenCheckingDateBetween_ThenFailure() {
        Date date = new Date(900);

        assertFalse("Date should be outside the boundaries", GeneralReportingService.isDateBetween(date, from, to));
    }

    @Test
    public void givenDateAfter_WhenCheckingDateBetween_ThenFailure() {
        Date date = new Date(3000);

        assertFalse("Date should be outside the boundaries", GeneralReportingService.isDateBetween(date, from, to));
    }

    @Test
    public void givenDateWithin_WhenCheckingDateBetween_ThenSuccess() {
        Date date = new Date(1500);

        assertTrue("Date should be inside the boundaries", GeneralReportingService.isDateBetween(date, from, to));
    }

    @Test
    public void givenBothDatesOutside_WhenCheckingAnyDateBetween_ThenFailure() {
        Date date1 = new Date(900);
        Date date2 = new Date(3000);

        assertFalse("Both dates should be outside", GeneralReportingService.isAnyDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenFirstDatesInside_WhenCheckingAnyDateBetween_ThenSuccess() {
        Date date1 = new Date(1500);
        Date date2 = new Date(3000);

        assertTrue("One date should be inside", GeneralReportingService.isAnyDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenSecondDatesInside_WhenCheckingAnyDateBetween_ThenSuccess() {
        Date date1 = new Date(900);
        Date date2 = new Date(1500);

        assertTrue("One date should be inside", GeneralReportingService.isAnyDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenBothDatesInside_WhenCheckingAnyDateBetween_ThenSuccess() {
        Date date1 = new Date(1500);
        Date date2 = new Date(1500);

        assertTrue("One date should be inside", GeneralReportingService.isAnyDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenBothDatesOutside_WhenCheckingAllDateBetween_ThenFailure() {
        Date date1 = new Date(900);
        Date date2 = new Date(3000);

        assertFalse("At least one date should be outside", GeneralReportingService.isAllDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenFirstDateOutside_WhenCheckingAllDateBetween_ThenFailure() {
        Date date1 = new Date(900);
        Date date2 = new Date(1500);

        assertFalse("At least one date should be outside", GeneralReportingService.isAllDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenSecondDateOutside_WhenCheckingAllDateBetween_ThenFailure() {
        Date date1 = new Date(1500);
        Date date2 = new Date(3000);

        assertFalse("At least one date should be outside", GeneralReportingService.isAllDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenBothDatesInside_WhenCheckingAllDateBetween_ThenSuccess() {
        Date date1 = new Date(1500);
        Date date2 = new Date(1600);

        assertTrue("Both Dates should be inside", GeneralReportingService.isAllDateBetween(date1, date2, from, to));
    }

    @Test
    public void givenReportingService_WhenGeneratingUserReport_Then() {
        ReportingServiceFactory reportingServiceFactory = mock(ReportingServiceFactory.class);
        UserReportingService reportingService = mock(UserReportingService.class);
        doReturn(reportingService).when(reportingServiceFactory).getReportingService(any(Long.class), any(Long.class), any(ReportingServices.class));
        GeneralReportingService generalReportingService = new GeneralReportingService(reportingServiceFactory);

        generalReportingService.getUserReporting(from, to);

        verify(reportingService, times(1)).generateReport();
    }

    @Test
    public void givenReportingService_WhenGeneratingFinishingsReport_Then() {
        ReportingServiceFactory reportingServiceFactory = mock(ReportingServiceFactory.class);
        FinishingsReportService reportingService = mock(FinishingsReportService.class);
        doReturn(reportingService).when(reportingServiceFactory).getReportingService(any(Long.class), any(Long.class), any(ReportingServices.class));
        GeneralReportingService generalReportingService = new GeneralReportingService(reportingServiceFactory);

        generalReportingService.getQuizFinishingReport(from, to);

        verify(reportingService, times(1)).generateReport();
    }

    @Test
    public void givenReportingService_WhenGeneratingSourceReport_Then() {
        ReportingServiceFactory reportingServiceFactory = mock(ReportingServiceFactory.class);
        SourceReportService reportingService = mock(SourceReportService.class);
        doReturn(reportingService).when(reportingServiceFactory).getReportingService(any(Long.class), any(Long.class), any(ReportingServices.class));
        GeneralReportingService generalReportingService = new GeneralReportingService(reportingServiceFactory);

        generalReportingService.getSourceReport(from, to);

        verify(reportingService, times(1)).generateReport();
    }

    @Test
    public void givenReportingService_WhenGeneratingFeedbackReport_Then() {
        ReportingServiceFactory reportingServiceFactory = mock(ReportingServiceFactory.class);
        FeedbackReportService reportingService = mock(FeedbackReportService.class);
        doReturn(reportingService).when(reportingServiceFactory).getReportingService(any(Long.class), any(Long.class), any(ReportingServices.class));
        GeneralReportingService generalReportingService = new GeneralReportingService(reportingServiceFactory);

        generalReportingService.getFeedbackReport(from, to);

        verify(reportingService, times(1)).generateReport();
    }

    @Test
    public void givenReportingService_WhenGeneratingTimeReport_Then() {
        ReportingServiceFactory reportingServiceFactory = mock(ReportingServiceFactory.class);
        TimeRequiredReportService reportingService = mock(TimeRequiredReportService.class);
        doReturn(reportingService).when(reportingServiceFactory).getReportingService(any(Long.class), any(Long.class), any(ReportingServices.class));
        GeneralReportingService generalReportingService = new GeneralReportingService(reportingServiceFactory);

        generalReportingService.getTimeRequiredReport(from, to);

        verify(reportingService, times(1)).generateReport();
    }

}
