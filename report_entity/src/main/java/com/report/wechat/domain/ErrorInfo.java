package com.report.wechat.domain;




public class ErrorInfo {
    private String errcode;
    private String errmsg;
    private final static String SUCCESS_CODE = "0";

    public String getErrcode() {
        return errcode;
    }

    @Override
	public String toString() {
		return "ErrorInfo [errcode=" + errcode + ", errmsg=" + errmsg + "]";
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
