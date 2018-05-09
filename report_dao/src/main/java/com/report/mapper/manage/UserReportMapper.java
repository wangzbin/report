package com.report.mapper.manage;

import com.report.common.pojo.UserReport;

import java.util.List;

public interface UserReportMapper{

    public int addUserReport(UserReport userReport);

    public UserReport selectUserReportData(int reportId);

    public UserReport selectUserReport(String reportTubeId);



}