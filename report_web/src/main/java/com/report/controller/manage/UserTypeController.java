package com.report.controller.manage;


import com.report.common.pojo.UserType;
import com.report.common.util.CommonResult;
import com.report.service.manage.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/type")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    /***
     * 增加分类
     * @param
     * @return
     */
    @RequestMapping("/addUserType")
    @ResponseBody
    public CommonResult addUserType(UserType userType) {

        if (null!=userType){
            userTypeService.addUserType(userType);
            return  CommonResult.ok("添加分类成功");
        }
        return  CommonResult.fail("添加分类失败");
    }

    @RequestMapping("/updateUserType")
    @ResponseBody
    public CommonResult updateUserType(UserType userType) {

        if (null!=userType){
            userTypeService.updateUserType(userType);
            return  CommonResult.ok("修改分类成功");
        }
        return  CommonResult.fail("修改分类失败");
    }

}
