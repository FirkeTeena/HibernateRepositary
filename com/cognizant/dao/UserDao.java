package com.cognizant.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	User findDistinctByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
}
