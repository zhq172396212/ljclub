package com.xt.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedisPool;


@Repository
public class JedisClientImpl implements JedisClient {
	
	@Autowired
	private ShardedJedisPool jedisPool;
	

	public void set(String key,String value) {
		jedisPool.getResource().getSet(key, value);
	}
	
	public String get(String key) {
		return jedisPool.getResource().get(key);
	}
	
	public void del(String key) {
		jedisPool.getResource().del(key);
	}
}


