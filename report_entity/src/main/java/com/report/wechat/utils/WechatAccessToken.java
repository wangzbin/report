package com.report.wechat.utils;



import java.util.TimerTask;




import com.alibaba.fastjson.JSONObject;
import com.report.common.util.LOG;
import com.report.common.util.RedisUtil;
import com.report.common.util.StringUtil;

/**
 * 定时刷新AccessToken
 * @author Administrator
 *
 */
public class WechatAccessToken extends TimerTask {
	
    private String access_token_url;
    
    private RedisUtil redisUtil;

    public WechatAccessToken(String access_token_url,RedisUtil redisUtil) {
        this.access_token_url = access_token_url;
        this.redisUtil = redisUtil;
    }

    /**
     * 由这个计时器任务执行操作.获取accessToken放入redis中
     */
    public void run() {
        try {
        	String response = HttpClientUtil.get(access_token_url);
            LOG.info("第一次获取access_token="+response);
            JSONObject json = JSONObject.parseObject(response);
            if (json.containsKey("access_token")) {
            	String accessToken = json.get("access_token").toString();
				if(StringUtil.isNotBlank(accessToken)) {
					redisUtil.set("accessToken", accessToken);
				}
			}else {
				
				LOG.error("access_token获取失败");
			}
        } catch (Exception e) {
        	LOG.error("获取access_token异常"+ e);
        	e.printStackTrace();
        }
    }


}
