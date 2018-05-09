package com.report.controller.frontend;

import com.report.common.util.*;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.report.service.frontend.ICreateTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.report.common.pojo.User;
import com.report.service.common.IUserService;
import com.report.service.wechat.IWeChatService;
import com.report.wechat.domain.WapUserInfo;
import com.report.wechat.domain.WeChatInfo;


/**
 * 登录注册
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/frontend")
public class RegisterLoginController {
	public static final long USER_INFO_TIME=7200L;

	public static final long USER_MESSAGE_CODE_TIME=120L;
	@Autowired
	private IWeChatService weChatService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICreateTokenService createToken;

	@Autowired
	private RedisUtil redisUtil;

/*	//方案一 :由服务器接受微信回调的code
	@RequestMapping("/callBack")
	public String callBack(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String code = request.getParameter("code");
		WapUserInfo wapUserInfo = weChatService.gainUserInfoByWap(code);
		User user = userService.selectByOpenId(wapUserInfo.getOpenid());
		//没有公众号
		if (null == user) {
			WeChatInfo weChatInfo = weChatService.gainUserInfoByOpenId(wapUserInfo.getOpenid(), wapUserInfo.getAccess_token());
			user.setCity(weChatInfo.getCity());
			user.setNickName(weChatInfo.getNickname());
			user.setOpenId(weChatInfo.getOpenid());
			user.setUserSex(Integer.valueOf(weChatInfo.getSex()));
			user.setCountry(weChatInfo.getCountry());
			user.setProvince(weChatInfo.getProvince());
			user.setHeadimgUrl(weChatInfo.getHeadimgurl());
			user.setUnionId(weChatInfo.getUnionid());
			try {
				userService.save(user);
			} catch (Exception e) {
				LOG.error("用户信息保存失败");
			}
		}
		//重定向回前端
		return null;

	}*/

	//方案二：前端接受微信发送的code
	@RequestMapping("/getUserTokenByCode/{code}")
	@ResponseBody
	public CommonResult getUserTokenByCode(@PathVariable String code) {
		WapUserInfo wapUserInfo = weChatService.gainUserInfoByWap(code);
		String openid = wapUserInfo.getOpenid();
		User user = userService.selectByOpenId(openid);
		if (null == user) {

			User newUser = new User();
			WeChatInfo weChatInfo = weChatService.gainUserInfoByOpenId(wapUserInfo.getOpenid(), wapUserInfo.getAccess_token());
			LOG.info(weChatInfo);
			newUser.setCity(weChatInfo.getCity());
			newUser.setNickName(weChatInfo.getNickname());
			newUser.setOpenId(weChatInfo.getOpenid());
			newUser.setUserSex(Integer.valueOf(weChatInfo.getSex()));
			newUser.setCountry(weChatInfo.getCountry());
			newUser.setProvince(weChatInfo.getProvince());
			newUser.setHeadimgUrl(weChatInfo.getHeadimgurl());
			newUser.setUnionId(weChatInfo.getUnionid());
			try {
				userService.save(newUser);
			} catch (Exception e) {
				LOG.error("用户信息保存失败");
			}
            String token = createToken.getToken(weChatInfo.getOpenid());
			redisUtil.set(weChatInfo.getOpenid(),user,USER_INFO_TIME);
            return CommonResult.ok("成功获取获取用户信息",token);
		}
        String token = createToken.getToken(user.getOpenId());
        redisUtil.set(user.getOpenId(),user,USER_INFO_TIME);
		return CommonResult.ok("成功获取获取用户信息",token);

	}

	/**
	 * 返回获取code的微信请求URL
	 *
	 * @return
	 */
	@RequestMapping("/getUserCodeUrl")
	@ResponseBody
	public CommonResult getUserCodeUrl() {
		CommonResult commonResult = weChatService.gainUserCode();
		return commonResult;
	}

	/**
	 * 刷新token
	 *
	 * @param openId
	 * @return
	 */
	@RequestMapping(value = "/refreshToken/{openId}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult refreshToken(@PathVariable String openId) {
		User user = userService.selectByOpenId(openId);

		String token = createToken.getToken(openId);

		return CommonResult.ok(token);
	}

	/**
	 * 短信验证码
	 *
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/sendPhoneMessage", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult sendPhoneMessage(@RequestParam(value = "phone", defaultValue = "") String phone,
										 @RequestParam(value = "token", defaultValue = "") String token) {
        if (StringUtil.isBlank(token)) {
            return CommonResult.fail("token为空");
        }
        String openId= createToken.tokenEncode(token);
        if (null == openId) {
            return CommonResult.fail("token失效");
        }
        try {
            User user = (User) redisUtil.get(openId);
            if (null == user) {
                User userByRedis = userService.selectByOpenId(openId);
                redisUtil.set(openId,userByRedis,USER_INFO_TIME);
            }
        } catch (Exception e) {
            LOG.error("token失效："+ e);
            return CommonResult.fail("获取数据失败");
        }

        //随机生成6位随机验证码
		String phoneRandom = SendMsgUtil.createRandomVcode(6);

		String content = "尊敬的用户，您的验证码为" + phoneRandom + ",有效期为120";

		if (!StringUtils.isBlank(phone)) {
			//发送短信。并放到redis中
			SendMsgUtil.sendMsg(phone, content);

			String timeNum = "phoneRandom_" + phone;
			//有效期60
			redisUtil.set(timeNum, phoneRandom, USER_MESSAGE_CODE_TIME);
			return CommonResult.build(CommonResult.SUCCESS, "true");
		}

		return CommonResult.build(CommonResult.FAIL, "false");

	}


	/**
	 * 通过token获取用户的名称
	 *
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "getUserNameByToken", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult getUserNameByToken( @RequestParam(value = "token", defaultValue = "") String token) {
        if (StringUtil.isBlank(token)) {
            return CommonResult.fail("token为空");
        }
        String openId= createToken.tokenEncode(token);
        if (null == openId) {
            return CommonResult.fail("token失效");
        }
        try {
            User user = (User) redisUtil.get(openId);
            if (null == user) {
                User userByRedis = userService.selectByOpenId(openId);
                redisUtil.set(openId,userByRedis,USER_INFO_TIME);
            }
            return CommonResult.ok("获取数据成功",user.getNickName());
        } catch (Exception e) {
            LOG.error("token失效："+ e);
            return CommonResult.fail("获取数据失败");
        }


	}

	/**
	 * 图形校验
	 *
	 * @return
	 */
	@RequestMapping(value = "graphicCalibration", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult graphicCalibration(@RequestParam(value = "token", defaultValue = "") String token) {
        if (StringUtil.isBlank(token)) {
            return CommonResult.fail("token为空");
        }
        String openId= createToken.tokenEncode(token);
        if (null == openId) {
            return CommonResult.fail("token失效");
        }
        try {
            User user = (User) redisUtil.get(openId);
            if (null == user) {
                User userByRedis = userService.selectByOpenId(openId);
                redisUtil.set(openId,userByRedis,USER_INFO_TIME);
            }
        } catch (Exception e) {
            LOG.error("token失效："+ e);
            return CommonResult.fail("获取数据失败");
        }
		ValidateCode vCode = new ValidateCode(160, 40, 5, 150);
		long time = new Date().getTime();
		String path = "D:/" + "image/" + time + ".png";
		String authCode = vCode.getCode();
		LOG.info(vCode.getCode() + " >" + path);
		try {
			vCode.write(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = "\\\\192.168.3.184\\image\\" + time+".png";
		Map<String, String> map = new HashMap<>();
		map.put("url", url);
		map.put("authCode", authCode);
		return CommonResult.ok(map);

	}

	/**
	 * 注册
	 * @param token
	 * @param phone
	 * @param authCode
	 * @param passWord
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "bindingPhone", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult bindingPhone(@RequestParam(value = "token", defaultValue = "") String token,
									 @RequestParam(value = "phone", defaultValue = "") String phone,
									 @RequestParam(value = "authCode", defaultValue = "") String authCode,
									 @RequestParam(value = "passWord", defaultValue = "") String passWord,
									 @RequestParam(value = "userName", defaultValue = "") String userName
								 ) {
		if (StringUtil.isBlank(token)) {
			return  CommonResult.fail("token为空");
		}
		String openId = createToken.tokenEncode(token);
		if (null == openId) {
			return CommonResult.fail("token失效");
		}
		User user = (User) redisUtil.get(openId);
		if (null == user) {
			User userByRedis = userService.selectByOpenId(openId);
			redisUtil.set(openId,userByRedis,USER_INFO_TIME);
		}
		if (StringUtil.isNotBlank(passWord)) {
			String encrypt = MD5.encrypt(passWord);
			user.setUserPwd(encrypt);
			try {
				//保存用户密码
				userService.updateUserPwdByOpenId(user);
			} catch (Exception e) {
				LOG.error("密码保存失败：" + e);
				return CommonResult.fail("注册失败");
			}
			return CommonResult.ok("注册成功");
		}
		String code = redisUtil.get("phoneRandom_" + phone).toString();
		if (StringUtil.isNotBlank(code)) {
			if (!authCode.equals(code)) {
				return CommonResult.fail("验证码已过期");
			}
			user.setUserName(userName);
			user.setUserPhone(phone);
			try {
				userService.updatePhoneByOpenId(user);
			} catch (Exception e) {
				LOG.error("绑定用户失败：" + e);
				return CommonResult.fail("绑定用户失败");
			}
			return CommonResult.ok("用户绑定成功");
		}
		return CommonResult.fail("注册失败");
	}

	/**
	 * Token校验
	 * @param token
	 * @return
	 */
/*	public  CommonResult tokenCheckout(String token) {
        if (StringUtil.isBlank(token)) {
            return CommonResult.fail("token为空");
        }
        String openId = createToken.tokenEncode(token);
        if (null == openId) {
            return CommonResult.fail("token失效");
        }

            User user = (User) redisUtil.get(openId);
            if (null == user) {
                User userByRedis = userService.selectByOpenId(openId);
                redisUtil.set(openId, userByRedis, 7200);
            }
        return CommonResult.fail("获取数据失败");

    }*/

}
