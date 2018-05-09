package com.report.service.frontend;



public interface ICreateTokenService {
	/**
	 * 获取token
	 * @param openId
	 * @return
	 */
	public String getToken(String openId);
	/**
	 * token解密
	 * @param token
	 * @return
	 */
	public String tokenEncode(String token);
}
