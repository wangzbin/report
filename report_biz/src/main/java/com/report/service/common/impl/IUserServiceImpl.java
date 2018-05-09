package com.report.service.common.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.common.pojo.User;
import com.report.common.util.LOG;
import com.report.mapper.UserMapper;
import com.report.service.base.impl.BaseServiceImpl;
import com.report.service.common.IUserService;

/**
 * 用户接口实现类
 * @author Administrator
 *
 */
@Service
public class IUserServiceImpl extends BaseServiceImpl<User> implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void updateByOpenid(User user) {
		userMapper.updateByOpenid(user);
		
	}
	@Override
	public User selectByOpenId(String openId) {
		User userInfo = userMapper.selectByOpenid(openId);
		LOG.info(userInfo);
		return userInfo;
	}
	@Override
	public void updatePhoneByOpenId(User user) {
		userMapper.updatePhoneByOpenId(user);
	}
	@Override
	public void updateUserPwdByOpenId(User user) {
		userMapper.updateUserPwdByOpenId(user);
	}

	@Override
	public void insertUserInfo(User user) {
		userMapper.insertUser(user);
	}


}
