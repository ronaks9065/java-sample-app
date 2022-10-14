package com.prodyna.dataprotection.navigator.task;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.util.longrunning.ConfluenceAbstractLongRunningTask;
import com.prodyna.dataprotection.navigator.service.reportingservices.GeneralReportingService;

import static com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext.GLOBAL_CONTEXT;
import static com.prodyna.dataprotection.navigator.model.PluginConstant.DPN_REPORT_ALL_CSV_TASK_KEY;

public class ReportAllCsvTask extends ConfluenceAbstractLongRunningTask {

    private final GeneralReportingService generalReportingService;
    private final BandanaManager bandanaManager;

    private final long from;
    private final long to;

    public ReportAllCsvTask(
            GeneralReportingService generalReportingService,
            BandanaManager bandanaManager,
            long from,
            long to
    ) {
        this.generalReportingService = generalReportingService;
        this.bandanaManager = bandanaManager;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void runInternal() {
        this.progress.setStatus("starting...");
        this.progress.setPercentage(1, 2);

        final String userReport = generalReportingService.getUserReporting(from, to).toCSV();
        final String quizReport = generalReportingService.getQuizFinishingReport(from, to).toCSV();
        final String sourceReport = generalReportingService.getSourceReport(from, to).toCSV();
        final String timeReport = generalReportingService.getTimeRequiredReport(from, to).toCSV();

        final String result = "\uFEFFReporting" + System.lineSeparator() + userReport + quizReport + sourceReport + timeReport;

        bandanaManager.setValue(GLOBAL_CONTEXT, DPN_REPORT_ALL_CSV_TASK_KEY, result);

        this.progress.setCompletedSuccessfully(true);
        this.progress.setPercentage(2, 2);
        this.progress.setStatus("finished.");
    }

    @Override
    public String getName() {
        return "report-all-csv-task";
    }
}
