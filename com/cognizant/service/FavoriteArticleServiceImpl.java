package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.FavoriteArticleDao;
import com.cognizant.entity.FavoriteArticle;
@Service
public class FavoriteArticleServiceImpl implements FavoriteArticleService {
	
	@Autowired
	private FavoriteArticleDao favoriteArticleDao;
	
	@Override
	public FavoriteArticle save(FavoriteArticle favoriteArticle) {
		return favoriteArticleDao.save(favoriteArticle);
	}

	@Override
	public void delete(FavoriteArticle favoriteArticle) {
		favoriteArticleDao.delete(favoriteArticle);
	}

	@Override
	public void deleteFavoriteArticle(int favoriteArticleId) {
		favoriteArticleDao.deleteFavoriteArticle(favoriteArticleId);
	}

	@Override
	public List<FavoriteArticle> findFavoriteArticle(int userId) {
		return favoriteArticleDao.findFavoriteArticle(userId);
	}
}