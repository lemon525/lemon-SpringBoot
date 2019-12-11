package com.redis.Redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RedisString {

    private StringRedisTemplate stringRedisTemplate;

    public void redisString(){
        //存入数据
        stringRedisTemplate.opsForValue().set("key","value");
        //存入数据设置缓存时间 TimeUnit.SECONDS 单位:秒
        stringRedisTemplate.opsForValue().set("key","value",1200, TimeUnit.SECONDS);
        //如果不存在则插入，返回true为插入成功,false失败
        Boolean absent = stringRedisTemplate.opsForValue().setIfAbsent("key", "value");

        Map<String,String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        //批量插入，key值存在会覆盖原值
        stringRedisTemplate.opsForValue().multiSet(map);

        //批量插入，如果里面的所有key都不存在，则全部插入，返回true，如果其中一个在redis中已存在，全不插入，返回false
        Boolean absent1 = stringRedisTemplate.opsForValue().multiSetIfAbsent(map);

        //获取值,key不存在返回null
        Object object = stringRedisTemplate.opsForValue().get("key");
        //批量获取，key不存在返回null
        List<String> list = stringRedisTemplate.opsForValue().multiGet(Arrays.asList("key1", "key2"));

        //获取指定字符串的长度
        Long size = stringRedisTemplate.opsForValue().size("key");
        //原有的值基础上新增字符串到末尾 返回长度
        Integer integer = stringRedisTemplate.opsForValue().append("key", "lemon");

        //获取原来key键对应的值并重新赋新值 返回原来值
        String str =stringRedisTemplate.opsForValue().getAndSet("key","lemon");

        //获取指定key的值进行减1，如果value不是integer类型，会抛异常，如果key不存在会创建一个，默认value为0
        stringRedisTemplate.opsForValue().decrement("keyint");
        //获取指定key的值进行加1，如果value不是integer类型，会抛异常，如果key不存在会创建一个，默认value为0
        stringRedisTemplate.opsForValue().increment("keyint");
        //删除指定key,成功返回true，否则false
        Boolean delete = stringRedisTemplate.opsForValue().getOperations().delete("key");
        //删除多个key，返回删除key的个数
        Long deleteL = stringRedisTemplate.opsForValue().getOperations().delete(Arrays.asList("key1", "key2"));
    }


}
