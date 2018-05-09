package com.report.service.common;

import com.report.common.pojo.User;
import com.report.service.base.IBaseService;

/**
 * 用户
 * @author Administrator
 *
 */
public interface IUserService extends IBaseService<User>{
	//通过oppid修改关注状态
	public void updateByOpenid(User user);
	
	//通过openid查询用户信息
	public User selectByOpenId(String openId);

	//通过oppid绑定手机账号
	public void updatePhoneByOpenId(User user);

	//注册
	public void updateUserPwdByOpenId(User user);
	//插入关注者的用户信息
	public void insertUserInfo(User user);
	
}
