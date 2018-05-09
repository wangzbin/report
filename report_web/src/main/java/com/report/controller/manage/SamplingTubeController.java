package com.report.controller.manage;

import com.github.pagehelper.PageInfo;
import com.report.common.pojo.SamplingTube;
import com.report.common.util.CommonResult;
import com.report.service.manage.SamplingTubeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage")
public class SamplingTubeController {

	@Autowired
	private SamplingTubeService samplingTubeService;

	/***
	 * excel上传采样管
	 * @param
	 * @return
	 */
	@RequestMapping("/uploadTubeExcel")
	@ResponseBody
	public CommonResult uploadTubeExcel(@RequestParam("excelName") MultipartFile sourceFile, HttpServletRequest request,HttpServletResponse response) {

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
		boolean b = samplingTubeService.addSamplingTubes(name,sourceFile);
		if(b){
			return CommonResult.build(CommonResult.SUCCESS,"success");
		}else{
			return CommonResult.build(CommonResult.FAIL,"flase");
		}
	
	}

	/***
	 * 新增采样管
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/tube/{tubeNumber}",method={RequestMethod.POST})
	@ResponseBody
	public CommonResult addTube(@PathVariable("tubeNumber") String tubeNumber) {

			if (StringUtils.isNotBlank(tubeNumber)){
				//添加采样管
				samplingTubeService.addSamplingTube(tubeNumber);
				return CommonResult.build(CommonResult.SUCCESS,"success");
			}

			return CommonResult.build(CommonResult.FAIL,"flase");

	}
	/***
	 * 删除采样管
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/deleteTube/{id}")
	@ResponseBody
	public CommonResult deleteTube(@PathVariable("id") Integer id) {

		if (null!=id){

			samplingTubeService.deleteTube(id);
			return CommonResult.build(CommonResult.SUCCESS,"success");
		}

		return CommonResult.build(CommonResult.FAIL,"flase");

	}
	/***
	 * 采样管分页查询
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getPageTubeList")
	@ResponseBody
	public CommonResult getPageTubeList(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "size",defaultValue = "20")int size,SamplingTube samplingTube) {

		//封装响应参数 status   success
		Map<String, Object> dataMap = new HashMap<String,Object>();
		if (null!=samplingTube){

			PageInfo<SamplingTube> pageList = samplingTubeService.getPageList(page, size, samplingTube);
			dataMap.put("total",pageList.getTotal());
			dataMap.put("rows",pageList.getList());
			return CommonResult.build(CommonResult.SUCCESS,"success",dataMap);
		}

		return CommonResult.build(CommonResult.FAIL,"flase");

	}

}
