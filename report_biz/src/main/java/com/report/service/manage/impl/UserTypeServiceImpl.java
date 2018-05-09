package com.report.service.manage.impl;

import com.report.common.pojo.UserType;
import com.report.mapper.manage.UserTypeMapper;
import com.report.service.manage.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeMapper userTypeMapper;

    @Override
    public int addUserType(UserType userType) {

        int i = userTypeMapper.insert(userType);
        return i;
    }

    @Override
    public int updateUserType(UserType userType) {

        int i = userTypeMapper.updateByPrimaryKey(userType);
        return i;
    }
}
