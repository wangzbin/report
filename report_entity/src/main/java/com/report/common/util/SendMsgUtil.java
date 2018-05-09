package com.report.common.util;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class SendMsgUtil
{
    public static String sendMsg(String phones, String content)
    {
        // 短信接口URL提交地址
        String url = "http://mess.kangmei.com.cn/Project/Msg/MsgService.aspx";

        Map<String, String> params = new HashMap<String, String>();

        params.put("user", "kmhdjy1");
        params.put("pwd", "123456");
        params.put("dxlbid", "42");
        params.put("extno", "");

        // 手机号码，多个号码使用英文逗号进行分割
        params.put("phone", phones);
        // 将短信内容进行URLEncoder编码
        params.put("content", URLEncoder.encode(content));

        return HttpRequestUtil.getRequest(url, params);
    }

    /**
     * 随机生成6位随机验证码 方法说明
     * 
     * @Discription:扩展说明
     * @return
     * @return String
     * @Author: feizi
     * @Date: 2015年4月17日 下午7:19:02
     * @ModifyUser：feizi
     * @ModifyDate: 2015年4月17日 下午7:19:02
     */
    public static String createRandomVcode(int num)
    {
        // 验证码
        String vcode = "";
        for (int i = 0; i < num; i++ )
        {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }

    /**
     * 测试 方法说明
     * 
     * @Discription:扩展说明
     * 
     * @param args
     * @return void
     * @Author: feizi
     * @Date: 2015年4月17日 下午7:26:36
     * @ModifyUser：feizi
     * @ModifyDate: 2015年4月17日 下午7:26:36
     */
    public static void main(String[] args)
    {
        System.out.println(SendMsgUtil.createRandomVcode(6));
        // System.out.println(&ecb=12.substring(1));
        System.out.println(sendMsg("15016934360",
            "尊敬的用户，您的验证码为 " + SendMsgUtil.createRandomVcode(6) + "，有效期为60秒"));
    }
}