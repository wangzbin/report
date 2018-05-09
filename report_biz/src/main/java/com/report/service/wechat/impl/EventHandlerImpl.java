package com.report.service.wechat.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.common.pojo.User;
import com.report.common.util.LOG;
import com.report.service.common.IUserService;
import com.report.service.wechat.IEventHandler;
import com.report.service.wechat.IWeChatService;
import com.report.wechat.domain.TextMessage;
import com.report.wechat.domain.WeChatInfo;
import com.report.wechat.utils.MessageUtil;


@Service
public class EventHandlerImpl implements IEventHandler {
	/*@Autowired
    private UserMapper userMapper;*/
	@Autowired
	private IWeChatService weChatService;
	@Autowired
	private IUserService userService;
	/**
	 * 微信具体的业务逻辑处理
	 */
	public String handle(Map<String, String> requestMap, HttpServletRequest request, HttpServletResponse response) {
		// 发送方帐号（open_id）
        String fromUserName = requestMap.get("FromUserName");
        // 公众帐号
        String toUserName = requestMap.get("ToUserName");
        // 消息类型,event和非event
        String msgType = requestMap.get("MsgType");
        
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(toUserName);
        textMessage.setToUserName(fromUserName);
        textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        textMessage.setCreateTime(new Date().getTime());
        //普通消息类型
        if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
        	textMessage.setContent("您好！欢迎来到小肠识公众号，您发送的是文本消息");
        //图片消息	
        }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
        	textMessage.setContent("您好！欢迎来到小肠识公众号，您发送的是图片消息");
		//音频消息	
		}else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			textMessage.setContent("您好！欢迎来到小肠识公众号，您发送的是音频消息");
		//链接消息
		}else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
			textMessage.setContent("您好！欢迎来到小肠识公众号，您发送的是链接消息");
		//地理位置消息	
		}else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			textMessage.setContent("您好！欢迎来到小肠识公众号，您发送的是地理位置消息");
		//事件消息	
		}else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			String evevtType = requestMap.get("Event");
			User user = new User();
			//关注事件
			if (evevtType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
				textMessage.setContent("您好！欢迎关注小肠识");
				//查询数据库是否已有此用户
				user.setOpenId(fromUserName);
				User user2 = userService.selectByOpenId(fromUserName);
				//不存在，保存用户信息
				if (null == user2) {
					//获取用户信息
					WeChatInfo weChatInfo = weChatService.gainUserInfoByEvent(fromUserName);
					LOG.info(weChatInfo);
					//保存用户信息
					user.setCity(weChatInfo.getCity());
					user.setNickName(weChatInfo.getNickname());
					user.setOpenId(fromUserName);
					user.setUserSex(Integer.valueOf(weChatInfo.getSex()));
					user.setCreateDate(new Date());
					user.setCountry(weChatInfo.getCountry());
					user.setProvince(weChatInfo.getProvince());
					user.setHeadimgUrl(weChatInfo.getHeadimgurl());
					user.setUnionId(weChatInfo.getUnionid());
					user.setSubscribe(1);
					userService.insertUserInfo(user);
					int a = 1/0;
				}else {
					//修改关注微信状态
					user.setSubscribe(1);
					user.setOpenId(fromUserName);
					userService.updateByOpenid(user);
				}
			}else if(evevtType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				user.setSubscribe(0);
				user.setOpenId(fromUserName);
				userService.updateByOpenid(user);
				LOG.info("取消关注成功");
			}
		//取消关注
	}
		return MessageUtil.messageToXml(textMessage);

	}
}