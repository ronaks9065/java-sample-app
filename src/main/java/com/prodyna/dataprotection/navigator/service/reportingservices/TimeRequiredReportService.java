package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.QuizItem;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.TimeRequiredLineDTO;
import com.prodyna.dataprotection.navigator.model.reporting.TimeRequiredReportingDTO;
import com.prodyna.dataprotection.navigator.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeRequiredReportService implements ReportingService {

    private final long from;
    private final long to;

    private final UserService userService;

    public TimeRequiredReportService(long from, long to, UserService userService) {
        this.from = from;
        this.to = to;
        this.userService = userService;
    }

    /**
     * Generates timeRequiredData for Report for the time between from and to.
     *
     * @return TimeRequiredReportDTO
     */
    @Override
    public TimeRequiredReportingDTO generateReport() {
        List<User> userList = userService.getAllUsers();
        List<QuizItem> quizzesList = userList.stream().flatMap(u -> u.getQuizes().stream()).collect(Collectors.toList());
        return new TimeRequiredReportingDTO(
                getTimeRequiredForLevel(1, 13, quizzesList),
                getTimeRequiredForLevel(2, 13, quizzesList),
                getTimeRequiredForLevel(4, 7, quizzesList));
    }

    private List<TimeRequiredLineDTO> getTimeRequiredForLevel(int level, int numberOfQuizzes, List<QuizItem> quizzesList) {
        List<TimeRequiredLineDTO> timeRequiredForCurrentLevelLines = new ArrayList<>();
        List<QuizItem> baseQuizzes = quizzesList.stream().filter(q -> q.getLevelID() == level).collect(Collectors.toList());
        for (int i = 0; i < numberOfQuizzes; i++) {
            int finalI = i;
            List<QuizItem> quizzesForCurrentLevel = baseQuizzes.stream().filter(q -> q.getQuizID() == finalI).collect(Collectors.toList());
            long noOfUsersAccessed = quizzesForCurrentLevel.stream().filter(q -> GeneralReportingService.isDateBetween(q.getStartingTime(), from, to)).count();
            long noOfUsersFinished = quizzesForCurrentLevel.stream().filter(q -> GeneralReportingService.isDateBetween(q.getFinishedTime(), from, to)).count();
            List<Long> times = quizzesForCurrentLevel.stream().filter(q -> GeneralReportingService.isAllDateBetween(q.getStartingTime(), q.getFinishedTime(), from, to)).mapToLong(q -> q.getFinishedTime().getTime() - q.getStartingTime().getTime()).boxed().collect(Collectors.toList());
            long minimumTime = times.stream().mapToLong(x -> x).min().orElse(0) / 1000;
            long maximumTime = times.stream().mapToLong(x -> x).max().orElse(0) / 1000;
            double averageTime = times.stream().mapToLong(x -> x).average().orElse(0) / 1000;
            timeRequiredForCurrentLevelLines.add(new TimeRequiredLineDTO("quiz" + i, noOfUsersAccessed, noOfUsersFinished, minimumTime, maximumTime, averageTime));
        }
        return timeRequiredForCurrentLevelLines;
    }
}
