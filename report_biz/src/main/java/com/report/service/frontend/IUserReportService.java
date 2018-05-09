package com.report.service.frontend;

import com.report.common.pojo.BacterialReference;
import com.report.common.pojo.SamplingTube;
import com.report.common.pojo.UserReport;
import com.report.common.util.CommonResult;

import java.util.List;

public interface IUserReportService {
    /**
     * 生成检测报告
     * @param reportTubeId
     * @return
     */
    public CommonResult addCreateReport(String reportTubeId);

   /**
     * 查询用户采样管检测数据
     * @return
     */
    public UserReport selectUserReportData(int reportTubeId);

    /**
     * 查询基线人群
     * @return
     */
    public List<BacterialReference> selectBacterialReference();

    /**
     * 根据采样管查询
     * @param reportTubeId
     * @return
     */
    public UserReport selectUserReport(String reportTubeId);


}
