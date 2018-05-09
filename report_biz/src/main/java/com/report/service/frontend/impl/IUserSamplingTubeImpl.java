package com.report.service.frontend.impl;

import com.report.common.pojo.SamplingTube;
import com.report.common.pojo.UserReport;
import com.report.common.util.CommonResult;
import com.report.mapper.manage.SamplingTubeMapper;
import com.report.mapper.manage.UserReportMapper;
import com.report.service.frontend.IUserSamplingTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户采样管接口实现类
 */
@Service
public class IUserSamplingTubeImpl implements IUserSamplingTube {
    @Autowired
    private SamplingTubeMapper samplingTubeMapper;

    @Autowired
    private UserReportMapper userReportMapper;
    /**
     * 根据用户id查询对应的采样管
     * @param userId
     * @return
     */
    @Override
    public CommonResult selectSamplingTubeList(Integer userId) {
        List<SamplingTube> tubeList = samplingTubeMapper.selectSamplingTubeList(userId);
        if (null == tubeList) {
            CommonResult.fail("此用户没有对应的采样管信息");
        }
        List<UserReport> list = new ArrayList<>();
        for(SamplingTube samplingTube: tubeList){
            UserReport userReport = userReportMapper.selectUserReport(samplingTube.getTubeNumber());
            list.add(userReport);
        }
        return CommonResult.ok("用户采样管查询成功",list);
    }
}
