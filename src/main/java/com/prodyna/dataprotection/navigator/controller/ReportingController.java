/*package com.prodyna.dataprotection.navigator.controller;

public class FeedbackController {
     post and produces json  input : Bewertung int,Kommentar string --- 200/201 ..badrequest



}*/

package com.prodyna.dataprotection.navigator.controller;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.ConfluenceUser;
import com.atlassian.confluence.util.longrunning.LongRunningTaskManager;
import com.atlassian.core.task.longrunning.LongRunningTask;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.prodyna.dataprotection.navigator.model.reporting.AllReportDTO;
import com.prodyna.dataprotection.navigator.service.AuthorizationService;
import com.prodyna.dataprotection.navigator.service.reportingservices.GeneralReportingService;
import com.prodyna.dataprotection.navigator.task.FeedbackAllCsvTask;
import com.prodyna.dataprotection.navigator.task.ReportAllCsvTask;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext.GLOBAL_CONTEXT;
import static com.prodyna.dataprotection.navigator.model.PluginConstant.DPN_FEEDBACK_ALL_CSV_TASK_KEY;
import static com.prodyna.dataprotection.navigator.model.PluginConstant.DPN_REPORT_ALL_CSV_TASK_KEY;

/**
 * This class includes endpoints, which enable access to different reports.
 *
 * @see com.prodyna.dataprotection.navigator.model.reporting.AllReportDTO
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("report")
public class ReportingController {

    private static final String YEAR_2100_TIMESTAMP = "4102441200000";
    private static final String CONTENT_DISPOSITION_HEADER = "Content-Disposition";
    private static final String ATTACHMENT_FILENAME = "attachment; filename=";

    private final LongRunningTaskManager longRunningTaskManager;
    private final BandanaManager bandanaManager;

    private final GeneralReportingService generalReportingService;

    private final AuthorizationService authorizationService;

    private LongRunningTask reportAllCsvTask;
    private LongRunningTask feedbackAllCsvTask;

    @Inject
    public ReportingController(
            @ComponentImport LongRunningTaskManager longRunningTaskManager,
            @ComponentImport BandanaManager bandanaManager,
            GeneralReportingService generalReportingService,
            AuthorizationService authorizationService
    ) {
        this.longRunningTaskManager = longRunningTaskManager;
        this.bandanaManager = bandanaManager;
        this.generalReportingService = generalReportingService;
        this.authorizationService = authorizationService;
    }

    /**
     * Provides a Json with all required reporting information.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return The report data as json, if the user is authorized, otherwise 403.
     * @see com.prodyna.dataprotection.navigator.model.reporting.AllReportDTO
     */
    @GET
    @Path("all")
    public Response getAllReports(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        final ConfluenceUser user = AuthenticatedUserThreadLocal.get();
        if (!authorizationService.isAllowedToAccessReports(user)) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        final AllReportDTO result = new AllReportDTO();

        result.setUserReportingDTO(generalReportingService.getUserReporting(from, to));
        result.setQuizFinishingsReportDTO(generalReportingService.getQuizFinishingReport(from, to));
        result.setTimeRequiredReportingDTO(generalReportingService.getTimeRequiredReport(from, to));
        result.setSourceReportDTO(generalReportingService.getSourceReport(from, to));

        return Response.status(Response.Status.OK)
                .entity(result)
                .build();
    }

    /**
     * Provides a csv with all required reporting information.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return The report data as csv, if the user is authorized, otherwise 403.
     */

    @GET
    @Path("all/csv")
    public Response getAllReportsCSV(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        final ConfluenceUser user = AuthenticatedUserThreadLocal.get();
        if (!authorizationService.isAllowedToAccessReports(user)) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        if (reportAllCsvTask == null) {
            startReportAllCsvTask(from, to, user);
        } else if (reportAllCsvTask.isSuccessful()) {
            reportAllCsvTask = null;

            final Object report = bandanaManager.getValue(GLOBAL_CONTEXT, DPN_REPORT_ALL_CSV_TASK_KEY);
            if (report != null) {
                return Response.ok(report)
                        .header(CONTENT_DISPOSITION_HEADER, ATTACHMENT_FILENAME + "Report.csv")
                        .build();
            }
        } else if (reportAllCsvTask.isComplete()) {
            startReportAllCsvTask(from, to, user);
        }

        return Response.ok(Response.Status.ACCEPTED)
                .build();
    }

    /**
     * Provides a json with all required user information.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return UserReportingDTO The user report data as json, if the user is authorized, otherwise 403.
     * @see com.prodyna.dataprotection.navigator.model.reporting.UserReportingDTO
     */

    @GET
    @Path("user")
    public Response getUserReport(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getUserReporting(from, to)).build();
    }

    /**
     * Provides a csv with all required user information.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return UserReportingDTO The user report data as csv, if the user is authorized, otherwise 403.
     */
    @GET
    @Path("user/csv")
    public Response getUserReportCSV(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.ok(generalReportingService.getUserReporting(from, to).toCSV()).header(CONTENT_DISPOSITION_HEADER, ATTACHMENT_FILENAME + "User.csv").build();
    }

    /**
     * This endpoint responds with the completion information of the Quizzes.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return QuizFinishingsReportDTO the completion information fo the Quizzes, if the user is authorized, otherwise 403.
     * @see com.prodyna.dataprotection.navigator.model.reporting.QuizFinishingsReportDTO
     */

    @GET
    @Path("finishes")
    public Response getFinishingReport(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getQuizFinishingReport(from, to)).build();
    }

    /**
     * This endpoint responds with the completion information of the Quizzes.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return A CSV with the completion information of the Quizzes, if the user is authorized, otherwise 403.
     */
    @GET
    @Path("finishes/csv")
    public Response getFinishingReportCSV(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        final ConfluenceUser user = AuthenticatedUserThreadLocal.get();
        if (!authorizationService.isAllowedToAccessReports(user)) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        if (feedbackAllCsvTask == null) {
            startFeedbackAllCsvTask(from, to, user);
        } else if (feedbackAllCsvTask.isSuccessful()) {
            feedbackAllCsvTask = null;

            final Object report = bandanaManager.getValue(GLOBAL_CONTEXT, DPN_FEEDBACK_ALL_CSV_TASK_KEY);
            if (report != null) {
                return Response.ok(report)
                        .header(CONTENT_DISPOSITION_HEADER, ATTACHMENT_FILENAME + "Finishings.csv")
                        .build();
            }
        } else if (feedbackAllCsvTask.isComplete()) {
            startFeedbackAllCsvTask(from, to, user);
        }

        return Response.ok(Response.Status.ACCEPTED)
                .build();
    }

    /**
     * This endpoint provides the source information as Json.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return SourceReportDTO The used Devices
     * @see com.prodyna.dataprotection.navigator.model.reporting.SourceReportDTO
     */
    @GET
    @Path("source")
    public Response getSourceReport(
            @QueryParam("from") long from,
            @QueryParam("to") long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getSourceReport(from, to)).build();
    }

    /**
     * This endpoint responds with the source information as CSV.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return A CSV with the source information, if the user is authorized, otherwise 403.
     */
    @GET
    @Path("source/csv")
    public Response getSourceReportCSV(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getSourceReport(from, to).toCSV()).header(CONTENT_DISPOSITION_HEADER, ATTACHMENT_FILENAME + "Devices.csv").build();
    }

    /**
     * This endpoint responds with the feedback information as json.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return FeedbackReportDTO the feedbacks, if the user is authorized
     * @see com.prodyna.dataprotection.navigator.model.reporting.FeedbackReportDTO
     */
    @GET
    @Path("feedback")
    public Response getFeedbackReport(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getFeedbackReport(from, to)).build();
    }

    /**
     * This endpoint responds with the feedback information as CSV.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return A CSV with the feedback information, if the user is authorized, otherwise 403.
     */
    @GET
    @Path("feedback/csv")
    public Response getFeedbackReportCSV(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getFeedbackReport(from, to).toCSV()).header(CONTENT_DISPOSITION_HEADER, ATTACHMENT_FILENAME + "Feedback.csv").build();
    }

    /**
     * This endpoint responds with the time reports as json.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return TimeRequiredReportingDTO the time reports, if the user is authorized, otherwise 403.
     */
    @GET
    @Path("timeRequired")
    public Response getTimeRequired(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getTimeRequiredReport(from, to)).build();
    }

    /**
     * This endpoint responds with the time reports as CSV.
     *
     * @param from the first date of report as linux timestamp in milliseconds.
     * @param to   the last date of report as linux timestamp in milliseconds.
     * @return TimeRequiredReportingDTO the time reports as CSV , if the user is authorized, otherwise 403.
     */
    @GET
    @Path("timeRequired/csv")
    public Response getTimeRequiredCSV(
            @QueryParam("from") long from,
            @QueryParam("to") @DefaultValue(YEAR_2100_TIMESTAMP) long to
    ) {
        if (!authorizationService.isAllowedToAccessReports(AuthenticatedUserThreadLocal.get())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.OK).entity(generalReportingService.getTimeRequiredReport(from, to).toCSV()).header(CONTENT_DISPOSITION_HEADER, ATTACHMENT_FILENAME + "TimeRequired.csv").build();
    }

    private void startReportAllCsvTask(long from, long to, ConfluenceUser user) {
        reportAllCsvTask = new ReportAllCsvTask(generalReportingService, bandanaManager, from, to);
        longRunningTaskManager.startLongRunningTask(user, reportAllCsvTask);
    }

    private void startFeedbackAllCsvTask(long from, long to, ConfluenceUser user) {
        feedbackAllCsvTask = new FeedbackAllCsvTask(generalReportingService, bandanaManager, from, to);
        longRunningTaskManager.startLongRunningTask(user, feedbackAllCsvTask);
    }
}
