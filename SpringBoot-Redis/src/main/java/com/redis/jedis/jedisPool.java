package com.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

public class jedisPool {

    @Resource
    private JedisPool jedisPool;

    public void jedis(){
        Jedis jedis = jedisPool.getResource();
        //使用命令
    }
}
