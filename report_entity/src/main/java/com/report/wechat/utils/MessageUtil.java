package com.report.wechat.utils;



import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.report.common.util.LOG;
import com.report.wechat.domain.Articles;
import com.report.wechat.domain.Event;
import com.report.wechat.domain.ImageMessage;
import com.report.wechat.domain.MusicMessage;
import com.report.wechat.domain.NewsMessage;
import com.report.wechat.domain.TextMessage;
import com.report.wechat.domain.VideoMessage;
import com.report.wechat.domain.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil {

    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    /**
     * 返回消息类型：视频
     */
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    /**
     * 返回消息类型：语音
     */
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    
    /**
     * 返回消息类型：图片
     */
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    
    
    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：un_subscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /**
     * 事件类型：扫码
     */
    public static final String EVENT_TYPE_SCAN = "SCAN";

    /**
     * 自定义CLICK事件:获取推广二维码
     */
    public static final  String CLICK_SEND_QRCODE = "CLICK_SEND_QRCODE";

    /**
     * xml转换为map
     *
     * @param request
     * @return
     * @throws java.io.IOException
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream ins = null;
        try {
            ins = request.getInputStream();
        } catch (IOException e1) {
            LOG.error(e1);
        }
        Document doc = null;
        try {
            doc = reader.read(ins);
            Element root = doc.getRootElement();
            recursiveParseXML(root,map);
            return map;
        } catch (DocumentException e1) {
            LOG.error(e1);
        } finally {
            ins.close();
        }
        return null;
    }
    //递归解析xml
    private static void recursiveParseXML(Element root,Map<String, String> map) {
    	List<Element> list = root.elements();
    	if (list.size() == 0) {
    		map.put(root.getName(), root.getTextTrim());
		}else{
			for (Element e : list) {
				recursiveParseXML(e,map);
            }
		}
	
    }
    /**
     * CDATA
     */
    private static XStream xstream = new XStream(new XppDriver() {
    	public HierarchicalStreamWriter createWriter(Writer out) {
    		return new PrettyPrintWriter(out) {
    			// 对所有xml节点都增加CDATA标记
    			boolean cdata = true;

    			public void startNode(String name, Class clazz) {
    				super.startNode(name, clazz);
    			}

    			protected void writeText(QuickWriter writer, String text) {
    				if (cdata) {
    					writer.write("<![CDATA[");
    					writer.write(text);
    					writer.write("]]>");
    				} else {
    					writer.write(text);
    				}
    			}
    		};
    	}
    });

    

    /**
     * 文本消息对象转换成xml
     *
     * @param event 消息事件对象
     * @return xml
     */
    public static String textMessageToXml(Event event) {
        XStream xstream = new XStream();
        xstream.alias("xml", event.getClass());
        return xstream.toXML(event);
    }
    /**
     * 文本消息转xml
     * @param textMessage
     * @return
     */
    public static String messageToXml(TextMessage textMessage) {
    	xstream.alias("xml", textMessage.getClass());
    	return xstream.toXML(textMessage);
    	
    }
    /**
     * 图片消息转xml
     * @param imageMessage
     * @return
     */
    public static String messageToXml(ImageMessage imageMessage) {
    	xstream.alias("xml", imageMessage.getClass());
    	return xstream.toXML(imageMessage);
    	
    }
    /**
     * 音乐消息转xml
     * @param musicMessage
     * @return
     */
    public static String messageToXml(MusicMessage musicMessage) {
    	xstream.alias("xml", musicMessage.getClass());
    	return xstream.toXML(musicMessage);
    	
    }
    /**
     * 视频消息转xml
     * @param videoMessage
     * @return
     */
    public static String messageToXml(VideoMessage videoMessage) {
    	xstream.alias("xml", videoMessage.getClass());
    	return xstream.toXML(videoMessage);
    	
    }
    /**
     * 语音消息转xml
     * @param voiceMessage
     * @return
     */
    public static String messageToXml(VoiceMessage voiceMessage) {
    	xstream.alias("xml", voiceMessage.getClass());
    	return xstream.toXML(voiceMessage);
    	
    }
    /**
     * 图本消息转xml
     * @param newsMessage
     * @return
     */
    public static String messageToXml(NewsMessage newsMessage) {
    	xstream.alias("xml", newsMessage.getClass());
    	xstream.alias("item", Articles.class);
    	return xstream.toXML(newsMessage);
    	
    }
    
}
