package com.report.wechat.domain;
/**
 * view类型按钮
 * @author Administrator
 *
 */
public class ViewButton extends BaseButton {
	private String type;
	private String url;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
