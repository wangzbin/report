package com.report.controller.manage;

import com.alibaba.fastjson.JSONObject;
import com.report.common.pojo.User;
import com.report.common.util.CommonResult;
import com.report.common.util.LOG;
import com.report.common.util.RedisUtil;
import com.report.common.util.SendMsgUtil;
import com.report.service.common.IUserService;
import com.report.service.manage.ReportService;
import com.report.service.wechat.IWeChatService;
import com.report.wechat.domain.WapUserInfo;
import com.report.wechat.domain.WeChatInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 *
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage")
public class UploadReportController {

	@Autowired
	private ReportService reportService;

	/***
	 * 上传excel
	 * @param
	 * @return
	 */
	@RequestMapping("/uploadReportExcel")
	@ResponseBody
	public CommonResult uploadReportExcel(@RequestParam("excelName") MultipartFile sourceFile, HttpServletRequest request,HttpServletResponse response) {

		//判断文件是否为空
		if (sourceFile==null) {
			return  CommonResult.build(CommonResult.FAIL,"flase");
		}
		//获取文件名
		String name=sourceFile.getOriginalFilename();
		//进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
		long size =sourceFile.getSize();
		if (name==null ||("").equals(name) && size==0) return CommonResult.build(CommonResult.FAIL,"flase");

		//批量导入。参数：文件名，文件。
		boolean b = reportService.addReport(name,sourceFile);
		if(b){
			return CommonResult.build(CommonResult.SUCCESS,"success");
		}else{
			return CommonResult.build(CommonResult.FAIL,"flase");
		}
	
	}


}
