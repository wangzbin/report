package com.report.test;


import com.report.common.util.JsonUtils;
import com.report.wechat.domain.BaseButton;
import com.report.wechat.domain.CompleButton;
import com.report.wechat.domain.Menu;
import com.report.wechat.domain.ViewButton;

public class TestButton {

	public static void main(String[] args) {
		ViewButton btn11 = new ViewButton();
		btn11.setName("我的健康");
		btn11.setType("view");
		btn11.setUrl("http://www.baidu.com/");
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("我的肠识");
		btn22.setType("view");
		btn22.setUrl("http://www.baidu.com/");
		
		ViewButton btn31 = new ViewButton();
		btn31.setName("参加活动");
		btn31.setType("view");
		btn31.setUrl("http://www.baidu.com/");
		
		ViewButton btn32 = new ViewButton();
		btn32.setName("报告案例");
		btn32.setType("view");
		btn32.setUrl("http://www.baidu.com/");
		
		ViewButton btn33 = new ViewButton();
		btn33.setName("帮助");
		btn33.setType("view");
		btn33.setUrl("http://www.baidu.com/");
		
		ViewButton btn34 = new ViewButton();
		btn34.setName("购买产品");
		btn34.setType("view");
		btn34.setUrl("http://www.baidu.com/");
		
		CompleButton btn3 = new CompleButton();
		btn3.setName("我的工具");
		btn3.setSub_button(new BaseButton[]{btn33,btn34,btn32,btn31});
		
		Menu menu = new Menu();
		menu.setButton(new BaseButton[]{btn11,btn22,btn3});
		
		String json = JsonUtils.objectToJson(menu);
		System.out.println(json);
	}

}
