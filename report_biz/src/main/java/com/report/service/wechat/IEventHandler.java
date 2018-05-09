package com.report.service.wechat;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/1.
 * 具体项目需要处理的业务逻辑
 */
public interface IEventHandler {

    /**
     * 具体处理逻辑
     * @param requestMap
     * @return
     */
    public String handle(Map<String, String> requestMap, HttpServletRequest request, HttpServletResponse response);

}
