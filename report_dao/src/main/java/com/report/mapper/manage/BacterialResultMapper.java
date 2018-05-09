package com.report.mapper.manage;

import com.report.common.pojo.BacterialResult;

public interface BacterialResultMapper {
    int insert(BacterialResult record);

    int insertSelective(BacterialResult record);
}