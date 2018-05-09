package com.report.controller.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.report.common.util.LOG;
import com.report.service.wechat.IWeChatService;

/**
 * 微信端请求处理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {
	
    @Autowired
    private IWeChatService weChatService;

    @ResponseBody
    @RequestMapping(value = "/api", method = {RequestMethod.GET, RequestMethod.POST})
    public void weChatApi(HttpServletRequest request, HttpServletResponse response){
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
    	LOG.debug("进入后台程序");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8");
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (isGet) {
                //如果为get方法则检测服务器连接，微信接入
                String signature = request.getParameter("signature");// 微信加密签名
                String timestamp = request.getParameter("timestamp");// 时间戳
                String nonce = request.getParameter("nonce");// 随机数
                String echostr = request.getParameter("echostr");//随机字符串
                if (weChatService.checkSignature(signature, timestamp, nonce)) {
                    LOG.info("Connect the weixin server is successful.");
                    
                    response.getWriter().write(echostr);
                } else {
                    LOG.error("Failed to verify the signature!");
                }
            } else {
                //如果为post访求则根据不同的消息类型进行相应处理
                String respMessage = "异常消息！";
                try {
                    respMessage = weChatService.handleEvent(request,response);
                    out.write(respMessage);
                    LOG.info("=================发送给微信服务器start==================>\n");
                    LOG.info("The request completed successfully\n");
                    LOG.info("to weixin server \n" + respMessage +"\n");
                    LOG.info("=================发送给微信服务器End====================>\n");
                } catch (Exception e) {
                   System.out.println();
                }
            }
        } catch (Exception e) {
            LOG.error(e);
        } finally {
            out.close();
        }
    }
}