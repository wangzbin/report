package com.report.service.frontend.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.report.common.util.LOG;
import com.report.service.frontend.ICreateTokenService;
@Service
public class ICreateTokenServiceImpl implements ICreateTokenService {
	/**
	 * 生成token的有效期
	 */
	public static final long MAXTIME = 1800;
    /**
     * 密钥
     */
    private static  final String SECRET="KMHD";
    /**
     * 默认字段key:exp
     */
    private static final String EXP="exp";
    /**
     * 默认字段key:payload
     */
    private static final String PAYLOAD="payload";
	/**
	 * 获取token
	 */
	public String getToken(String openId) {
		String token = null;
		 try{
	            final JWTSigner signer=new JWTSigner(SECRET);
	            final Map<String ,Object> data=new HashMap<>(10);
	            ObjectMapper objectMapper=new ObjectMapper();
	            String jsonString=objectMapper.writeValueAsString(openId);
	            data.put(PAYLOAD,jsonString);
	            data.put(EXP,System.currentTimeMillis()+MAXTIME);
	            token = signer.sign(data);
	        } catch (IOException e) {
	            e.printStackTrace();
	            LOG.error("生成token错误:"+ e);
	            return null;
	        }
		return token;
	}
	/**
	 * token解密
	 */
	public String tokenEncode(String token) {
		 String json = null;
		 final JWTVerifier jwtVerifier=new JWTVerifier(SECRET);
	        try{
	            final Map<String,Object> data=jwtVerifier.verify(token);
	            //判断数据是否超时或者符合标准
	            if(data.containsKey(EXP)&&data.containsKey(PAYLOAD)){
	                long exp= (long) data.get(EXP);
	                long currentTimeMillis=System.currentTimeMillis();
	                if(exp<currentTimeMillis){
	                    json = data.get(PAYLOAD).toString().replace("\"","");
	                }
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	            LOG.error("token解密失败");
	            return null;
	        }
		return json;
	}

}
