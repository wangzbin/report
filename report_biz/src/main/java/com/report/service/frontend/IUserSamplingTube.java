package com.report.service.frontend;

import com.report.common.pojo.SamplingTube;
import com.report.common.util.CommonResult;

import java.util.List;

/**
 * 用户采样管接口
 */
public interface IUserSamplingTube {
    /**
     * 根据用户id查询对应的采样管
     * @param userId
     * @return
     */
    public CommonResult selectSamplingTubeList(Integer userId);
}
