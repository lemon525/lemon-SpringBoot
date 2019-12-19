package com.redis.Redis;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.*;

public class RedisHash {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void redisHash(){
        //新增hashmap值
        stringRedisTemplate.opsForHash().put("hash","hash-key","hash-value");
        //以map集合的形式添加键值对
        Map<String,String> map = new HashMap<>();
        map.put("hash-key2","hash-value2");
        map.put("hash-key3","hash-value3");
        stringRedisTemplate.opsForHash().putAll("hash",map);
        //如果变量值存在，在变量中可以添加不存在的的键值对，
        //如果变量不存在，则新增一个变量，同时将键值对添加到该变量。添加成功返回true否则返回false
        Boolean absent = stringRedisTemplate.opsForHash().putIfAbsent("hash", "hash-key", "value1");
        //获取指定变量中的hashMap值
        List<Object> values = stringRedisTemplate.opsForHash().values("hash");
        //获取变量中的键值对
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("hash");
        //获取变量中的指定map键是否有值,如果存在该map键则获取值，没有则返回null。
        Object value = stringRedisTemplate.opsForHash().get("hash", "hash-key");
        //获取变量中的键。
        Set<Object> keys = stringRedisTemplate.opsForHash().keys("hash");
        //获取变量的长度
        Long size = stringRedisTemplate.opsForHash().size("hash");
        //使变量中的键以long值的大小进行自增长。值必须为Integer类型,否则异常
        Long increment = stringRedisTemplate.opsForHash().increment("hash", "hash-key2", 1);
        //以集合的方式获取变量中的值。
        List<Object> valuelist= stringRedisTemplate.opsForHash().multiGet("hash", Arrays.asList("hash-key", "hash-key1"));
        // 删除变量中的键值对，可以传入多个参数，删除多个键值对。返回删除成功数量
        Long delete = stringRedisTemplate.opsForHash().delete("hash", "hash-key", "hash-key1");

    }
}
