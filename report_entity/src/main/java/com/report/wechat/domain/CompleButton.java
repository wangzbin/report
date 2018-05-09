package com.report.wechat.domain;
/**
 * 复合类型菜单(包含二级菜单的以及菜单)
 * @author Administrator
 *
 */
public class CompleButton extends BaseButton {
	public BaseButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(BaseButton[] sub_button) {
		this.sub_button = sub_button;
	}

	private BaseButton[] sub_button;
}
