package com.prodyna.dataprotection.navigator.service.reportingservices;

import com.prodyna.dataprotection.navigator.model.AccessEntry;
import com.prodyna.dataprotection.navigator.model.DeviceType;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.reporting.SourceReportDTO;
import com.prodyna.dataprotection.navigator.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class SourceReportService implements ReportingService {

    private final long to;
    private final long from;
    private final UserService userService;

    public SourceReportService(long from, long to, UserService userService) {
        this.from = from;
        this.to = to;
        this.userService = userService;
    }

    /**
     * Generates sourceData for Report for the time between from and to.
     *
     * @return SourceReportDTO
     */
    @Override
    public SourceReportDTO generateReport() {
        List<User> userList = userService.getAllUsers();
        SourceReportDTO reportingDTO = new SourceReportDTO();
        List<AccessEntry> accesses = userList.stream().flatMap(user -> user.getAccessEntries().stream()).filter(entry -> GeneralReportingService.isDateBetween(entry.getAccessTime(), from, to)).collect(Collectors.toList());
        long mobileAccesses = accesses.stream().filter(entry -> entry.getAccessDevice().equals(DeviceType.MOBILE)).count();
        long tabletAccesses = accesses.stream().filter(entry -> entry.getAccessDevice().equals(DeviceType.TABLET)).count();
        long desktopAccesses = accesses.stream().filter(entry -> entry.getAccessDevice().equals(DeviceType.DESKTOP)).count();
        reportingDTO.setMobile(mobileAccesses);
        reportingDTO.setTablet(tabletAccesses);
        reportingDTO.setDesktop(desktopAccesses);
        return reportingDTO;
    }
}
