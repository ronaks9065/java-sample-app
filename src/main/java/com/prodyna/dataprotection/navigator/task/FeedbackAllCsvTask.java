package com.prodyna.dataprotection.navigator.task;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.util.longrunning.ConfluenceAbstractLongRunningTask;
import com.prodyna.dataprotection.navigator.service.reportingservices.GeneralReportingService;

import static com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext.GLOBAL_CONTEXT;
import static com.prodyna.dataprotection.navigator.model.PluginConstant.DPN_FEEDBACK_ALL_CSV_TASK_KEY;

public class FeedbackAllCsvTask extends ConfluenceAbstractLongRunningTask {

    private final GeneralReportingService generalReportingService;
    private final BandanaManager bandanaManager;

    private final long from;
    private final long to;

    public FeedbackAllCsvTask(
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

        final String result = generalReportingService.getQuizFinishingReport(from, to).toCSV();

        bandanaManager.setValue(GLOBAL_CONTEXT, DPN_FEEDBACK_ALL_CSV_TASK_KEY, result);

        this.progress.setCompletedSuccessfully(true);
        this.progress.setPercentage(2, 2);
        this.progress.setStatus("finished.");
    }

    @Override
    public String getName() {
        return "feedback-all-csv-task";
    }
}
