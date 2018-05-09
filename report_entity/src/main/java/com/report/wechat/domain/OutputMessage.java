package com.report.wechat.domain;



import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by RGFAX on 2017/3/31.
 */
@XStreamAlias("xml")
public class OutputMessage {
    private String ToUserName;//CDATA
    private String FromUserName;//CDATA
    private String CreateTime;
    private String MsgType;//CDATA text:文本 image:图片 link:链接
    private String Content;//CDATA
    private String MsgId;//
    private String Title;
    private String Description;
    private String Url;

    private Image Image;

    public OutputMessage(){}

    public static class Image{

        private String MediaId;

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String mediaId) {
            MediaId = "<![CDATA["+mediaId+"]]>";
        }
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = "<![CDATA["+title+"]]>";
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = "<![CDATA["+description+"]]>";
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = "<![CDATA["+url+"]]>";
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = "<![CDATA["+toUserName+"]]>";
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = "<![CDATA["+fromUserName+"]]>";
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = "<![CDATA["+msgType+"]]>";
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = "<![CDATA["+content+"]]>";
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = "<![CDATA["+msgId+"]]>";
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image Image) {
        this.Image = Image;
    }

    public static String sendTextMessage(String toUserName,String fromUserName,String content){
        OutputMessage message = new OutputMessage();
        message.setFromUserName(toUserName);
        message.setToUserName(fromUserName);
        message.setCreateTime(System.currentTimeMillis()+"");
        message.setMsgType("text");
        message.setContent(content);
        XStream xStream = new XStream();
        xStream.alias("xml", OutputMessage.class);
        return xStream.toXML(message)
                .replaceAll("&lt;","<")
                .replaceAll("&gt;",">")
                .replaceAll("&quot;","\"");
    }

    public static String sendImgMessage(String toUserName,String fromUserName,String mediaId){
        OutputMessage message = new OutputMessage();
        OutputMessage.Image image1 = new Image();
        image1.setMediaId(mediaId);
        message.setFromUserName(toUserName);
        message.setMsgType("image");
        message.setToUserName(fromUserName);
        message.setImage(image1);
        message.setCreateTime(System.currentTimeMillis() + "");
        XStream xStream = new XStream();
        xStream.alias("xml", OutputMessage.class);
        return xStream.toXML(message)
                .replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">")
                .replaceAll("&gt;",">")
                .replaceAll("&quot;","\"");
    }

    public static String sendLinkMessage(String toUserName,String fromUserName,String title,String description,String url){
        OutputMessage message = new OutputMessage();
        message.setFromUserName(toUserName);
        message.setToUserName(fromUserName);
        message.setCreateTime(System.currentTimeMillis() + "");
        message.setMsgType("link");
        message.setTitle(title);
        message.setDescription(description);
        message.setUrl(url);
        XStream xStream = new XStream();
        xStream.alias("xml", OutputMessage.class);
        return xStream.toXML(message)
                .replaceAll("&lt;","<")
                .replaceAll("&gt;",">")
                .replaceAll("&gt;",">")
                .replaceAll("&quot;","\"");
    }
}
