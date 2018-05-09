package com.report.wechat.domain;

import java.util.List;
/**
 *图文消息
 * @author Administrator
 *
 */
public class NewsMessage extends BaseMessage {
	private int ArticleCount;
	
	private List<Articles> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Articles> getArticles() {
		return Articles;
	}

	public void setArticles(List<Articles> articles) {
		Articles = articles;
	}
	
}
