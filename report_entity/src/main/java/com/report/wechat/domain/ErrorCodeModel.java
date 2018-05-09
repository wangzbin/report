package com.report.wechat.domain;



/**
 * Created by Administrator on 2017/4/1.
 */
public class ErrorCodeModel {

    private String errcode;//全局返回码
    private String errmsg;//说明

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
