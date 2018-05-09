package com.report.service.wechat;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.report.common.util.CommonResult;
import com.report.wechat.domain.Customer;
import com.report.wechat.domain.ErrorInfo;
import com.report.wechat.domain.Media;
import com.report.wechat.domain.Ticket;
import com.report.wechat.domain.WapUserInfo;
import com.report.wechat.domain.WeChatInfo;

/**
 * Created by RGFAX
 */
public interface IWeChatService {

    /**
     * 检测密钥
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    boolean checkSignature(String signature, String timestamp, String nonce);

    /**
     * 获取tooken
     * @return
     */
    String gainCommonToken();

    /**
     * 处理微信post请求的各种事件消息
     * @param request
     * @return
     */
    String handleEvent(HttpServletRequest request, HttpServletResponse response);

    /**
     * 通过事件获取用户信息
     * @param openId
     * @return
     */
    WeChatInfo gainUserInfoByEvent(String openId);//获取用户信息

    /**
     * 通过网页获取用户信息
     * @param code
     * @return
     */
    WapUserInfo gainUserInfoByWap(String code);//在微信浏览器上获取取得用户信息的openid,access_token等信息

    /**
     * 获取带参数的微信关注二维码
     * @param sceneStr 参数字符串
     * @return
     */
    Ticket gainQRCode(String sceneStr);//获取二维码信息

    /**
     * 创建菜单
     * @param json 菜单JSOn
     * @return
     */
    ErrorInfo generateMenu(String json);

    /**
     * 上传图片素材
     * @param filePath 图片路径
     * @return
     */
    public Media uploadImg(String filePath);

    /**
     * 添加客服
     * @param customer
     * @return
     */
    ErrorInfo generateCustomer(Customer customer);
    /**
     * 发送客服消息
     * @param content
     * @param openId
     */
    void sendCustomerTextInfo(String content, String openId);
    
    /**
     * 上传图片素材
     * @param state
     * @param url
     * @return
     */
    String packagingUrl(String state, String url);
    /**
     * 获取用户网页授权的Code
     * @return
     */
    CommonResult gainUserCode();
    
    /**
     * 拉取未关注网页授权用户信息
     * @return
     */
    WeChatInfo gainUserInfoByOpenId(String openId,String access_token);
}
