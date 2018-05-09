package com.report.service.frontend.impl;

import com.report.mapper.manage.UserReportMapper;
import com.report.service.frontend.IUserFloraDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户菌群接口实现类
 */
@Service
public class IUserFloraDataServiceImpl implements IUserFloraDataService {
    @Autowired
    private UserReportMapper userReportMapper;

    @Override
    /**
     * 报告查询
     */
    public Object selectReport(String tubeId) {

        return null;
    }
}
