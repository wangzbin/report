package com.report.service.manage.impl;

import com.report.common.pojo.BacterialReport;
import com.report.common.pojo.BigReport;
import com.report.common.pojo.PylumResult;
import com.report.common.pojo.UserReport;
import com.report.common.util.ExcelUtils;
import com.report.common.util.LOG;
import com.report.mapper.manage.BacterialReportMapper;
import com.report.mapper.manage.PylumResultMapper;
import com.report.mapper.manage.UserReportMapper;
import com.report.service.manage.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private UserReportMapper userReportMapper;
    @Autowired
    private BacterialReportMapper bacterialReportMapper;

    @Autowired
    private PylumResultMapper pylumResultMapper;

    @Override
    public boolean addReport(String name, MultipartFile sourceFile) {

        boolean b = false;
        //创建处理EXCEL
        ExcelUtils readExcel=new ExcelUtils();

        //初始化
        Map<String, Object> excelInfo = null;
        List<BigReport> bigReportList = null;
        List<PylumResult> pylumResultList =null;

        try {
            //解析excel，获取报告信息集合。
            excelInfo = readExcel.getExcelInfo(name, sourceFile);
        } catch (IOException e) {

            LOG.error("解析excel失败");
        }

        if(excelInfo != null){
            bigReportList = (List<BigReport>) excelInfo.get("bigReportList");
            pylumResultList = (List<PylumResult>) excelInfo.get("pylumResultList");
            b = true;
        }

        //迭代添加信息
        for (BigReport bigReport : bigReportList) {
            //添加用户报告表

            bacterialReportMapper.addBacterialReport(bigReport.getBacterialReport());
            BacterialReport bacterialReport = bigReport.getBacterialReport();
            //添加菌种表
            UserReport userReport = bigReport.getUserReport();
            userReport.setBacterialReport(bacterialReport);
            userReportMapper.addUserReport(userReport);



        }
        //迭代添加信息
        for (PylumResult pylumResult : pylumResultList) {
            pylumResultMapper.insert(pylumResult);
        }

        return b;
    }

    @Override
    public Object selectReport(String tubeId) {

        return null;
    }
}
