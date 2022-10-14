package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.QuizFinishingsReportDTO;
import com.prodyna.dataprotection.navigator.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class FinishingsReportService implements ReportingService {

    private final long from;
    private final long to;

    private final UserService userService;

    public FinishingsReportService(long from, long to, UserService userService) {
        this.from = from;
        this.to = to;
        this.userService = userService;
    }


    /**
     * Generate the finishingsData for Reporting for the time between from and to
     *
     * @return QuizFinishingsReportDTO the finishingsData
     */
    @Override
    public QuizFinishingsReportDTO generateReport() {
        QuizFinishingsReportDTO quizFinishingsReportDTO = new QuizFinishingsReportDTO();
        quizFinishingsReportDTO.setBaseResults(getBaseFinishing());
        quizFinishingsReportDTO.setBaseResultsSum(
                quizFinishingsReportDTO.getBaseResults().stream().reduce(0L, Long::sum)
        );
        quizFinishingsReportDTO.setAdvancedResults(getAdvancedFinishing());
        quizFinishingsReportDTO.setAdvancedResultsSum(
                quizFinishingsReportDTO.getAdvancedResults().stream().reduce(0L, Long::sum)
        );
        quizFinishingsReportDTO.setExpertResults(getExpertFinishing());
        quizFinishingsReportDTO.setExpertResultsSum(
                quizFinishingsReportDTO.getExpertResults().stream().reduce(0L, Long::sum)
        );
        quizFinishingsReportDTO.setBaseCertificatesReceived(getBaseCertificatesAccessed());
        quizFinishingsReportDTO.setAdvancedCertificatesReceived(getAdvancedCertificatesAccessed());
        quizFinishingsReportDTO.setExpertCertificatesReceived(getExpertCertificatesAccessed());
        quizFinishingsReportDTO.setAllCertificatsReceived(
                quizFinishingsReportDTO.getBaseCertificatesReceived() +
                        quizFinishingsReportDTO.getAdvancedCertificatesReceived() +
                        quizFinishingsReportDTO.getExpertCertificatesReceived()
        );

        return quizFinishingsReportDTO;
    }

    private List<Long> getBaseFinishing() {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            results.add(getFinishing(1, i));
        }
        return results;
    }

    private List<Long> getAdvancedFinishing() {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            results.add(getFinishing(2, i));
        }
        return results;
    }

    private List<Long> getExpertFinishing() {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            results.add(getFinishing(4, i));
        }
        return results;
    }

    private Long getFinishing(int level, int quizNumber) {
        List<User> userList = userService.getAllUsers();
        Long allFinishers = 0L;
        for (User user : userList) {
            if (user.getQuizes().stream().anyMatch(q -> q.getLevelID() == level && q.getQuizID() == quizNumber && GeneralReportingService.isDateBetween(q.getFinishedTime(), from, to))) {
                allFinishers++;
            }
        }
        return allFinishers;
    }

    private long getBaseCertificatesAccessed() {
        List<User> users = userService.getAllUsers();
        return users.stream().filter(user -> GeneralReportingService.isDateBetween(user.getBasicCertificateAccessed(), from, to)).count();
    }

    private long getAdvancedCertificatesAccessed() {
        List<User> users = userService.getAllUsers();
        return users.stream().filter(user -> GeneralReportingService.isDateBetween(user.getAdvancedCertificateAccessed(), from, to)).count();
    }

    private long getExpertCertificatesAccessed() {
        List<User> users = userService.getAllUsers();
        return users.stream().filter(user -> GeneralReportingService.isDateBetween(user.getExpertCertificateAccessed(), from, to)).count();
    }

}
