package com.report.mapper.manage;

import com.report.common.pojo.PylumResult;

public interface PylumResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PylumResult record);

    int insertSelective(PylumResult record);

    PylumResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PylumResult record);

    int updateByPrimaryKey(PylumResult record);
}