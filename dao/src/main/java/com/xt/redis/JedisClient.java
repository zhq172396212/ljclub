package com.xt.redis;

public interface JedisClient {
	
	public void set(String key, String value);
	
	public String get(String key);
	
	public void del(String key);
}
