package com.redis.serviceimpl;


import com.redis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisServiceImplTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setTest(){
        Boolean delete = stringRedisTemplate.opsForList().getOperations().delete("key");
        System.out.println(delete);
    }

    @Test
    public void getTest(){
        List<String> lists = stringRedisTemplate.opsForList().range("key", 0, -1);
        lists.forEach(list-> System.out.println(list));

    }
    @Test
    public void test(){
        stringRedisTemplate.opsForList().trim("key", 0, 3);
    }


}