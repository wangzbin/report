package com.report.common.util;



/**
 * json公共返回结果
 */
public class CommonResult{

  
    // 响应业务状态
    private Integer status = SUCCESS;
    public final static Integer SUCCESS = 200;//成功响应码
    public final static Integer FAIL = 201;//失败响应码

   

    // 响应消息
    private String msg = "操作成功!";

    // 响应中的数据
    private Object data;

    public static CommonResult build(Integer status, String msg, Object data) {
        return new CommonResult(status, msg, data);
    }

    public static CommonResult build(Integer status, String msg) {
        return new CommonResult(status, msg, null);
    }


    public static CommonResult ok() {
        return new CommonResult(null);
    }

    public static CommonResult ok(Object data) {
        return new CommonResult(data);
    }

    public static CommonResult ok(String msg){
        return build(CommonResult.SUCCESS,msg);
    }

    public static CommonResult ok(String msg, Object data){
        return build(CommonResult.SUCCESS, msg, data);
    }


    public static CommonResult fail() {
        return build(CommonResult.FAIL, "失败");
    }

    public static CommonResult fail(Object data) {
        return build(CommonResult.FAIL, "失败", data);
    }

    public static CommonResult fail(String msg){
        return build(CommonResult.FAIL,msg);
    }

    public static CommonResult fail(String msg, Object data){
        return build(CommonResult.FAIL, msg, data);
    }


    public CommonResult() {

    }

    public CommonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public CommonResult(Object data) {
        this.status = SUCCESS;
        this.msg = "OK";
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isOk(){
        return SUCCESS.equals(this.status);
    }

}

