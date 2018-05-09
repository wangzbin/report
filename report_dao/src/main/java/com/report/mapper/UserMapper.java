package com.report.mapper;
import com.github.abel533.mapper.Mapper;
import com.report.common.pojo.User;

import java.util.List;

public interface UserMapper extends Mapper<User>{
	

	public void updateByOpenid(User user);
	
	public User selectByOpenid(String openId);

	public void updatePhoneByOpenId(User user);

	public void updateUserPwdByOpenId(User user);

	public void insertUser(User user);


	public User selectByUserId(Integer userId);

	public List<User> selectUserByPaging(User user);




}