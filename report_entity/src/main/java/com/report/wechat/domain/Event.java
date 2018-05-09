package com.report.wechat.domain;







public class Event {
    private String ToUserName;//CDATA
    private String FromUserName;//CDATA
    private String CreateTime;//
    private String MsgType;//CDATA event
    private String Event;//CDATA subscribe:订阅 unsubscribe:取消订阅 SCAN:已经订阅再次扫码 CLICK:点击菜单事件 VIEW:点击菜单跳转链接时的事件推送
    //扫描带参数二维码事件
    //CDATA
    //subscribe或者SCAN:事件KEY值，qrscene_为前缀，后面为二维码的参数值
    //CLICK:事件KEY值，与自定义菜单接口中KEY值对应
    //VIEW:事件KEY值，设置的跳转URL
    private String EventKey;
    private String Ticket;//CDATA 二维码的ticket，可用来换取二维码图片

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
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
        MsgType = msgType;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
