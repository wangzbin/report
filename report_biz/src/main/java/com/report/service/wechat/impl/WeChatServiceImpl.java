package com.report.service.wechat.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.report.common.util.*;
import com.report.common.util.SHA1;
import com.report.mapper.manage.BacterialReportMapper;
import com.report.mapper.manage.UserReportMapper;
import com.report.service.frontend.IUserReportService;
import com.report.service.wechat.IEventHandler;
import com.report.service.wechat.IWeChatService;
import com.report.wechat.domain.*;
import com.report.wechat.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Timer;


/**
 * 微信接口实现类
 * @author Administrator
 *
 */
@Service
public class WeChatServiceImpl implements IWeChatService {
	@Autowired
	private IUserReportService userReportService;
	@Autowired
	private UserReportMapper userReportMapper;
	@Autowired
	private BacterialReportMapper bacterialReportMapper;

	@Autowired
    private IEventHandler handler;

	@Value("${wechat_token}")
	private String token;
	
	@Value("${wechat_appid}")
    private String appID;

    @Value("${wechat_appSecret}")
    private String appSecret;

    @Value("${wechat_accessToken_enableWork}")
	private boolean enableWork;
    
    @Value("${wechat_number}")
    private String number;
	@Autowired
    private RedisUtil redisUtil;
	
	@PostConstruct
    public void startTask() {
        if (enableWork) {
        	gainUserCode();
        	//初始化时生成公众号菜单
        	generateMenu(ViewJsonData.getJsonData());
            String access_token_url = new StringBuilder(WechatApiUrl.ACCESS_TOKEN_URL).append("?grant_type=client_credential&appid=").append(appID).append("&secret=").append(appSecret).toString();
			//userReportService.addCreateReport("SRR413588");
			Timer timer = new Timer();
			/*List<BacterialReference> bacterialReferences = userReportMapper.selectUserPort();

			for(BacterialReference s: bacterialReferences) {
				LOG.info(s);
			}*/


			//延迟3秒后启动，每隔20分钟执行一次
            timer.schedule(new WechatAccessToken(access_token_url,redisUtil), 3000, 1200000);
            //Customer customer = new Customer();
        	//ErrorInfo generateCustomer = generateCustomer(customer);
        	
        }
    }
	public boolean checkSignature(String signature, String timestamp, String nonce) {
		 String[] arr = new String[]{token, timestamp, nonce};
	        // 将token、timestamp、nonce三个参数进行字典序排序
	        Arrays.sort(arr);
	        // 将三个参数字符串拼接成一个字符串进行sha1加密
	        String tmpStr = SHA1.encode(arr[0] + arr[1] + arr[2]);
	        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
	        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	/**
     * 处理微信post请求的各种事件消息
     * @param request
     * @return
     */
	public String handleEvent(HttpServletRequest request, HttpServletResponse response) {
		 String message = "success";
	        try {
	            // xml请求解析,封装成map对象
	            Map<String, String> requestMap = MessageUtil.xmlToMap(request);
	            message = handler.handle(requestMap, request, response);
	        } catch (Exception e) {
	            LOG.error(e);
	        }
	         return message;
		
	}
	/**
	 * 发送客服消息
	 */
	public void sendCustomerTextInfo(String content, String openId) {
		 LOG.info("=====发送客服信息=====>" + appID);
		 	String access_token = gainCommonToken();
	        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + access_token;
	        String jsonStr = "{" + "    \"touser\":\"" + openId + "\"," + "    \"msgtype\":\"text\"," + "    \"text\":" + "    {" + "         \"content\":\"" + content + "\"" + "    }" + "}";
	        String log = "发送客服信息失败";
	        try {
	            HttpClientUtil.post(url, jsonStr);
	            LOG.info(content);
	        } catch (Exception e) {
	            LOG.error(log + e);
	        }
	}

	public String packagingUrl(String state, String url) {
		return null;
	}
	/**
	 * 获取accessToken
	 */
	public String gainCommonToken() {
		String Token = redisUtil.get("accessToken").toString();
		if (StringUtil.isBlank(Token)) {
			String access_token_url = new StringBuilder(WechatApiUrl.ACCESS_TOKEN_URL).append("?grant_type=client_credential&appid=").append(appID).append("&secret=").append(appSecret).toString();
			String response = HttpClientUtil.get(access_token_url);
			LOG.info("第二次获取access_token="+response);
            JSONObject json = JSONObject.parseObject(response);
            if (json.containsKey("access_token")) {
            	String accessToken = json.get("access_token").toString();
				if(StringUtil.isNotBlank(accessToken)) {
					redisUtil.set("accessToken", accessToken);
				}
				return accessToken;
			}else {
				LOG.error("无法获取accessToken");
				return null;
			}
		}
        return Token;
	}
	/**
     * 通过事件获取用户信息
     * @param openId
     * @return
     */
	public WeChatInfo gainUserInfoByEvent(String openId) {
		LOG.info("=====获取用户信息=====>" + appID);
        String token = gainCommonToken();
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + token + "&openid=" + openId + "&lang=zh_CN";
        String log = "获取微信用户信息出错:";
        String text;
        try {
            text = HttpClientUtil.get(url);
        } catch (Exception e) {
            LOG.error(log + e);
            return null;
        }
        JSONObject object = JSONObject.parseObject(text);
        object.put(JSON.DEFAULT_TYPE_KEY, WeChatInfo.class.getName());
        WeChatInfo object1 = JSON.parseObject(object.toJSONString(), WeChatInfo.class);
        if (null != object1.getErrcode() && !object1.getErrcode().equals("0")) {
            LOG.error(log + "错误编号:" + object1.getErrcode() + ",错误信息:" + object1.getErrmsg());
            return object1;
        }
        return object1;
        
	}
	/**
     * 通过网页获取用户信息
     * @param code
     * @return
     */
	public WapUserInfo gainUserInfoByWap(String code) {
		LOG.info("=====获取网页凭证信息=====>" + appID);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + this.appID + "&secret=" + this.appSecret + "&code=" + code + "&grant_type=authorization_code";
        String log = "获取网页凭证信息出错,code已被使用,";
        String text;
        try {
            text = HttpClientUtil.get(url);
        } catch (Exception e) {
            LOG.error(log + e);
            return null;
        }
        JSONObject object = JSONObject.parseObject(text);
        object.put(JSON.DEFAULT_TYPE_KEY, WapUserInfo.class.getName());
        WapUserInfo object1 = JSON.parseObject(object.toJSONString(), WapUserInfo.class);
        if (null != object1.getErrcode() && !object1.getErrcode().equals("0")) {
            LOG.debug(log + "错误编号:" + object1.getErrcode() + ",错误信息:" + object1.getErrmsg());
            return null;
        }
        return object1;
		
	}
	/**
     * 获取带参数的微信关注二维码
     * @param sceneStr 参数字符串
     * @return
     */
	public Ticket gainQRCode(String sceneStr) {
		return null;
	}
	/**
	 * 创建菜单
	 */
	public ErrorInfo generateMenu(String json) {
		 LOG.info("=====创建微信公众号菜单=====>" + appID);
	        String access_token = gainCommonToken();
	        
	        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
	        String text;
	        String log = "创建微信公众号菜单出错:";
	        try {
	            text = HttpClientUtil.post(url, json);
	        } catch (Exception e) {
	            LOG.error(log + e);
	            return null;
	        }
	        JSONObject object = JSONObject.parseObject(text);
	        object.put(JSON.DEFAULT_TYPE_KEY, ErrorInfo.class.getName());
	        ErrorInfo object1 = JSON.parseObject(object.toJSONString(), ErrorInfo.class);
			LOG.info("=====创建微信公众号成功=====>" + appID);
	        return object1;
	}
	/**
     * 上传图片素材
     * @param filePath 图片路径
     * @return
     */
	public Media uploadImg(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * 添加客服
     */
	public ErrorInfo generateCustomer(Customer customer) {
		LOG.info("=====添加客服=====>" + appID);
		String access_token = gainCommonToken();
		
        String url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=" + access_token;
        String log = "添加客服失败";
        String text;
        String Kf_account = customer.getKf_account() + "@" + number;
        customer.setKf_account(Kf_account);
        customer.setNickname("小美");
        String json = customer.toJsonString();
        try {
            text = HttpClientUtil.post(url, json);
        } catch (Exception e) {
            LOG.error(log + e);
            return null;
        }
        LOG.info("添加客服成功");
        ErrorInfo errorInfo = JsonUtils.jsonToPojo(text, ErrorInfo.class);
        LOG.info(errorInfo);
        return errorInfo;
	}
	/**
	 * 获取用户网页授权的code
	 */
	
	public CommonResult gainUserCode() {
		LOG.info("=====网页授权Code======");
		String encode;
		String url = null;
		try {
			encode = URLEncoder.encode("http://14093c35.nat123.cc","GBK");
			//String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ appID + "&redirect_uri=" + encode + "&response_type" + "code"+ ""

			url = new StringBuffer(WechatApiUrl.CODE_URL).append("?appid=").append(appID).append("&redirect_uri=").append(encode).append("&response_type=").append("code").append("&scope=").append("snsapi_userinfo").append("&state=").append("123").append("#wechat_redirect").toString();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			LOG.error("返回code的url出错");
		}
		LOG.info(url);
		return new CommonResult(200,"获取成功",url);
	}

	/**
	 * 拉取未关注网页授权用户信息
	 */
	public WeChatInfo gainUserInfoByOpenId(String openId, String access_token) {
		LOG.info("=====拉取用户信息======");
		String info = null;
		try {
			String url= "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openId +"&lang=zh_CN" ;
			info = HttpClientUtil.get(url);
		} catch (Exception e) {
		}
		JSONObject object = JSONObject.parseObject(info);
		object.put(JSON.DEFAULT_TYPE_KEY, WeChatInfo.class.getName());
		WeChatInfo weChatInfo = JSON.parseObject(object.toJSONString(), WeChatInfo.class);
		return weChatInfo;
	}

}

