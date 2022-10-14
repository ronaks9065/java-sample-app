package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.UserReportingDTO;
import com.prodyna.dataprotection.navigator.service.UserService;

import java.util.List;

public class UserReportingService implements ReportingService {

    private final long from;
    private final long to;

    private final UserService userService;

    public UserReportingService(long from, long to, UserService userService) {
        this.from = from;
        this.to = to;
        this.userService = userService;
    }

    /**
     * Generates userData for Report for the time between from and to.
     *
     * @return UserReportDTO
     */
    @Override
    public UserReportingDTO generateReport() {
        UserReportingDTO userReportingDTO = new UserReportingDTO();
        userReportingDTO.setUniqueVisitors(getUniqueVisitorCount());
        userReportingDTO.setBaseSessions(getBaseSessions());
        userReportingDTO.setAdvancedSessions(getAdvancedSessions());
        userReportingDTO.setExpertSessions(getExpertSessions());
        userReportingDTO.setSessions(
                userReportingDTO.getBaseSessions() +
                        userReportingDTO.getAdvancedSessions() +
                        userReportingDTO.getExpertSessions()
        );

        return userReportingDTO;
    }

    private int getUniqueVisitorCount() {
        int uniqueVisitors = 0;
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            if (user.getQuizes().stream().anyMatch(quiz -> GeneralReportingService.isAnyDateBetween(quiz.getStartingTime(), quiz.getFinishedTime(), from, to))) {
                uniqueVisitors++;
            }
        }
        return uniqueVisitors;
    }

    private int getBaseSessions() {
        return getSessions(1);
    }

    private int getAdvancedSessions() {
        return getSessions(2);
    }

    private int getExpertSessions() {
        return getSessions(4);
    }

    private int getSessions(int level) {
        int sessions = 0;
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            sessions += user.getQuizes().stream().filter(quiz -> quiz.getLevelID() == level).filter(quiz -> GeneralReportingService.isDateBetween(quiz.getStartingTime(), from, to)).count();
        }
        return sessions;
    }
}
