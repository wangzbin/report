package com.report.controller.wechat;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.report.common.util.LOG;

/**
 * 微信端请求处理
 * @author Administrator
 *
 */
@Controller
public class TestController {
	
   

    @ResponseBody
    @RequestMapping(value = "/sss", method = {RequestMethod.GET, RequestMethod.POST})
    public void add(){
    	Logger logger  =  Logger.getRootLogger();
    	LOG.debug("SSSSS");
    	LOG.error("jfsf");
        logger.debug( " debug " );
        logger.error( " error " );
    }
}