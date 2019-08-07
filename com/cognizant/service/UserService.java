package com.cognizant.service;

import com.cognizant.entity.User;

public interface UserService {
	User save(User user);

	User findUser(String username, String password);

	User findByUsername(String username);
	void delete(User user);
//	Set<FavoriteArticle> findByFavoriteArticle();
}
