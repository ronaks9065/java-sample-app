package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.AccessEntry;
import com.prodyna.dataprotection.navigator.model.DeviceType;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.SourceReportDTO;
import com.prodyna.dataprotection.navigator.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class SourceReportServiceTest {

    private UserService userService;
    private SourceReportService sourceReportService;

    @Before
    public void setup() {
        userService = mock(UserService.class);
        sourceReportService = new SourceReportService(0, 1000, userService);
    }

    @Test
    public void givenNoUser_WhenGenerating_ThenDefaultValues() {
        doReturn(new ArrayList<User>()).when(userService).getAllUsers();

        SourceReportDTO sourceReport = sourceReportService.generateReport();

        testEmptyResult(sourceReport);
    }

    private void testEmptyResult(SourceReportDTO sourceReport) {
        assertEquals("There should be no Desktop Users", 0, sourceReport.getDesktop());
        assertEquals("There should be no Mobile Users", 0, sourceReport.getMobile());
        assertEquals("There should be no Tablet Users", 0, sourceReport.getTablet());
    }

    @Test
    public void givenUsers_WhenGenerating_ThenCorrectValues() {
        List<User> userList = generateUserList();
        doReturn(userList).when(userService).getAllUsers();

        SourceReportDTO sourceReport = sourceReportService.generateReport();

        assertEquals("Wrong amount of Desktop Users", 1, sourceReport.getDesktop());
        assertEquals("Wrong amount of Mobile Users", 2, sourceReport.getMobile());
        assertEquals("Wrong amount of Tablet Users", 3, sourceReport.getTablet());
    }

    @Test
    public void givenUsersOutOfTimeRange_WhenGenerating_ThenThoseAreNotIncluded() {
        List<User> userList = generateUserList();
        for (User user : userList) {
            user.getAccessEntries().get(0).setAccessTime(new Date(1500));
        }
        doReturn(userList).when(userService).getAllUsers();

        SourceReportDTO sourceReport = sourceReportService.generateReport();

        testEmptyResult(sourceReport);
    }

    private List<User> generateUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(generateUser(DeviceType.DESKTOP));
        for (int i = 0; i < 2; i++) {
            userList.add(generateUser(DeviceType.MOBILE));
        }
        for (int i = 0; i < 3; i++) {
            userList.add(generateUser(DeviceType.TABLET));
        }
        return userList;
    }

    private User generateUser(DeviceType deviceType) {
        User user = new User();
        user.addAccessEntry(new AccessEntry(new Date(500), deviceType));
        return user;
    }
}
