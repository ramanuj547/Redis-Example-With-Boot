package com.learn.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.learn.redis.model.User;

@SpringBootApplication
public class SpringRedisApplication {

	
	/*
	 * JedisConnection Factory here you can specify server and host port no as well
	 */
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		
		return new JedisConnectionFactory();
	}
	
	/*
	 * Here setting jedisConnectionFactory to redisTemplate we'll use
	 */
	@Bean
	RedisTemplate<String, User> redisTemplate(){
		
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<String, User>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringRedisApplication.class, args);
	}
}
