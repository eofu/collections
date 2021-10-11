package com.myself.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RedisDemo {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");

		// 字符串
		jedis.set("String", "www");
		System.out.println(jedis.get("String"));

		// List列表
		jedis.lpush("my-list", "1");
		jedis.lpush("my-list", "2");
		jedis.lpush("my-list", "3");
		jedis.lpush("my-list", "4");
		List<String> lrange = jedis.lrange("my-list", 0, 3);
		for (String s : lrange) {
			System.out.println(s);
		}

		// keys
		Set<String> keys = jedis.keys("*");
		for (String key : keys) {
			System.out.println(key);
		}
	}
}
