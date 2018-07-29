package com.learn.redis.repository;

import java.util.Map;

import com.learn.redis.model.User;

public interface UserRepository {

	void save(User user);
	Map<String , User> getAllUser();
	User findById(String id);
	void update(User user);
	void delete(String id);
	
}
