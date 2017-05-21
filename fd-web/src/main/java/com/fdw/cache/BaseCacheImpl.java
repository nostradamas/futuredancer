package com.fdw.cache;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * 基础的缓存实现
 * 
 * @author candy
 *
 */
public class BaseCacheImpl {

	@Resource
	protected RedisTemplate<String, Object> redisTemplate;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
