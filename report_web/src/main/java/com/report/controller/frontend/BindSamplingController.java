package com.report.controller.frontend;

import com.report.common.pojo.User;
import com.report.common.util.CommonResult;
import com.report.common.util.RedisUtil;
import com.report.common.util.StringUtil;
import com.report.service.common.IUserService;
import com.report.service.frontend.ICreateTokenService;
import com.report.service.frontend.IUserSamplingTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 绑定用户采样管
 */
@Controller
@RequestMapping("/frontend")
public class BindSamplingController {
    public static final long USER_INFO_TIME=7200L;
    @Autowired
    private ICreateTokenService createToken;
    @Autowired
    private IUserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IUserSamplingTube userSamplingTube;
    /**
     *展示用户采样管
     * @param token
     * @return
     */
    @RequestMapping(value = "showUserSampling", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult showUserSampling(@RequestParam(value = "token", defaultValue = "") String token) {
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
        CommonResult commonResult = userSamplingTube.selectSamplingTubeList(user.getUserId());
        return commonResult;
    }

}
