package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDao;
import com.cognizant.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User findUser(String username, String password) {
		
		return userDao.findDistinctByUsernameAndPassword(username, password);
	}

	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

//	@Override
/*	public Set<FavoriteArticle> findByFavoriteArticle() {
		Iterable<FavoriteArticle> favoriteArticles = userDao.findByFavoriteArticle();
	}*/
}
