package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

public class FavoriteArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1483936101198787257L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="fav_article_id")
	private int favArticleId;
	private int articleId;
	private String url;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	public FavoriteArticle() {
		super();
	}

	public int getFavArticleId() {
		return favArticleId;
	}

	public void setFavArticleId(int favArticleId) {
		this.favArticleId = favArticleId;
	}


	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FavoriteArticle [favArticleId=" + favArticleId + ", articleId=" + articleId + ", url=" + url + ", user="
				+ user + "]";
	}
}