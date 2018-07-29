package com.learn.redis.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.learn.redis.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private RedisTemplate<String, User> redisTemplate;
	
	/*
	 * Use HashOperation to operate on redis template
	 */
	private HashOperations<String, String, User> hashOperations;
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash(); // HashOperations to Operate on redis
	}

	public void save(User user) {
		
		hashOperations.put("USER", user.getId(), user);
	}

	public Map<String , User> getAllUser() {
		
		return hashOperations.entries("USER");
	}

	public void update(User user) {
		save(user);
	}

	public void delete(String id) {
		hashOperations.delete("USER", id);
	}

	public User findById(String id) {
		return hashOperations.get("USER", id);
	}

	
}
