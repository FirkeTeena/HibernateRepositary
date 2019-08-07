package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.FavoriteArticle;

public interface FavoriteArticleService {
	FavoriteArticle save(FavoriteArticle favoriteArticle);
	void delete(FavoriteArticle favoriteArticle);
	void deleteFavoriteArticle(int favoriteArticleId);
	List<FavoriteArticle>findFavoriteArticle(int userId);
}