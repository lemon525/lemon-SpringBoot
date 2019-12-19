package com.redis.Redis;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

public class RedisSet {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void redisSet(){

        //向变量中批量添加值。返回添加的数量
        Long add = stringRedisTemplate.opsForSet().add("set", "a", "b", "c");
        //获取变量的值
        Set<String> set = stringRedisTemplate.opsForSet().members("set");
        //获取变量中值得长度
        Long size = stringRedisTemplate.opsForSet().size("set");
        //随机获取变量中的某个元素
        String member = stringRedisTemplate.opsForSet().randomMember("set");
        //随机获取变量中指定个数的元素
        List<String> members = stringRedisTemplate.opsForSet().randomMembers("set", 2);
        //检查给定的元素是否在变量中,true为存在
        Boolean member1 = stringRedisTemplate.opsForSet().isMember("set", "b");
        //转义变量的元素值到另一个变量中
        Boolean move = stringRedisTemplate.opsForSet().move("set", "b", "set1");
        //弹出变量中的元素。当元素全部弹完,变量也会删除
        String pop = stringRedisTemplate.opsForSet().pop("set");
        //批量删除变量中的元素,返回删除的数量
        Long remove = stringRedisTemplate.opsForSet().remove("set1", "b");
        //通过集合求差值。
        Set<String> difference = stringRedisTemplate.opsForSet().difference("set", "set1");
        //将求出来的差值元素保存
        Long aLong = stringRedisTemplate.opsForSet().differenceAndStore("set", "set1", "set2");
        //获取去重的随机元素
        Set<String> set1 = stringRedisTemplate.opsForSet().distinctRandomMembers("set", 2);
        //获取两个变量中的交集
        Set<String> intersect = stringRedisTemplate.opsForSet().intersect("set", "set1");
        //获取2个变量交集后保存到最后一个变量上。
        Long aLong1 = stringRedisTemplate.opsForSet().intersectAndStore("set", "set1", "set2");
        //获取两个变量的合集
        Set<String> union = stringRedisTemplate.opsForSet().union("set", "set1");
        //获取两个变量合集后保存到另一个变量中
        Long aLong2 = stringRedisTemplate.opsForSet().unionAndStore("set", "set1", "set2");
    }


}
