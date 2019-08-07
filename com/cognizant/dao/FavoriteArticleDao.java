package com.cognizant.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.entity.FavoriteArticle;

public interface FavoriteArticleDao extends CrudRepository<FavoriteArticle, Long> {
	
	default void deleteFavoriteArticle(int favoriteArticleId){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createSQLQuery("DELETE FROM Favorite_Article WHERE fav_Article_Id = :favArticleId");
			query.setParameter("favArticleId", favoriteArticleId);
			Transaction tx = session.beginTransaction();
			
			query.executeUpdate();
			tx.commit();
			

			}catch(HibernateException e){
				System.out.println("Record couldn't be inserted..." + e.getMessage());
			}
	}
	
	default List<FavoriteArticle> findFavoriteArticle(int userId){
		List<FavoriteArticle>favoriteArticles = new ArrayList<>();
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createSQLQuery("SELECT * FROM Favorite_Article WHERE user_id = :userId");
			query.setParameter("userId", userId);
			Transaction tx = session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Object[]>articles = query.list();
			
			Iterator<Object[]>itrFavArticles = articles.iterator();
			
			FavoriteArticle favoriteArticle = null;
			
			while(itrFavArticles.hasNext()){
				Object[] record = itrFavArticles.next();
				favoriteArticle = new FavoriteArticle();
				favoriteArticle.setFavArticleId(new Integer(record[0].toString()));
				favoriteArticle.setArticleId(new Integer(record[1].toString()));
				favoriteArticle.setUrl(record[2].toString());
				
				favoriteArticles.add(favoriteArticle);
			}
			tx.commit();
			

			}catch(HibernateException e){
				System.out.println("Record couldn't be inserted..." + e.getMessage());
			}
		return favoriteArticles;
	}	
}