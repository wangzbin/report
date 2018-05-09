package com.report.wechat.domain;
/**
 * 语音消息
 * @author Administrator
 *
 */
public class VoiceMessage extends BaseMessage {
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
	
}
