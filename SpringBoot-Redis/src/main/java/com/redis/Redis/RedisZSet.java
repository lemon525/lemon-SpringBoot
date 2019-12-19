package com.redis.Redis;

import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class RedisZSet {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void redisZSet(){

        //添加元素到变量中同时指定元素的分值。
        Boolean add = stringRedisTemplate.opsForZSet().add("zset", "a", 1);
        //通过TypedTuple方式新增数据。
        ZSetOperations.TypedTuple<String> typedTuple1 = new DefaultTypedTuple<>("b",2.0);
        ZSetOperations.TypedTuple<String> typedTuple2 = new DefaultTypedTuple<>("c",3.0);
        ZSetOperations.TypedTuple<String> typedTuple3 = new DefaultTypedTuple<>("d",4.0);
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        typedTupleSet.add(typedTuple1);
        typedTupleSet.add(typedTuple2);
        typedTupleSet.add(typedTuple3);
        Long zset = stringRedisTemplate.opsForZSet().add("zset", typedTupleSet);
        //获取指定区间的元素
        Set<String> zset1 = stringRedisTemplate.opsForZSet().range("zset", 0, -1);
        //于获取满足非score的排序取值。这个排序只有在有相同分数的情况下才能使用，如果有不同的分数则返回值不确定。
        Set<String> rangeByLex = stringRedisTemplate.opsForZSet().rangeByLex("zset",
                RedisZSetCommands.Range.range().lt("c"));
        //用于获取满足非score的设置下标开始的长度排序取值。
        Set<String> zset2 = stringRedisTemplate.opsForZSet().rangeByLex("zset", RedisZSetCommands.Range.range().lt("c"),
                RedisZSetCommands.Limit.limit().offset(1).count(2));
        //根据设置的score获取区间值。
        Set<String> zset3 = stringRedisTemplate.opsForZSet().rangeByScore("zset", 1, 3);
        //获取RedisZSetCommands.Tuples的区间值
        Set<ZSetOperations.TypedTuple<String>> zset4 = stringRedisTemplate.opsForZSet().rangeWithScores("zset", 1, 3);
       /* assert zset != null;
        for (ZSetOperations.TypedTuple<String> next : zset) {
            String value = next.getValue();
            Double score = next.getScore();
            System.out.println(value + "-->" + score);
        }*/
       //获取区间值的个数。
        Long zsetCount = stringRedisTemplate.opsForZSet().count("zset", 1, 3);
        //获取变量中指定元素的索引,下标开始为0
        Long rank = stringRedisTemplate.opsForZSet().rank("zset", "a");
        //匹配获取键值对，ScanOptions.NONE为获取全部键值对；
        // ScanOptions.scanOptions().match("C").build()匹配获取键位map1的键值对,不能模糊匹配。
        Cursor<ZSetOperations.TypedTuple<String>> zset6 = stringRedisTemplate.opsForZSet().scan("zset", ScanOptions.NONE);
       /* while (zset6.hasNext()) {
            ZSetOperations.TypedTuple<String> next = zset6.next();
            System.out.println(next.getValue() + "-->" + next.getScore());
        }*/
        //获取指定元素的分值
        Double score = stringRedisTemplate.opsForZSet().score("zset", "a");
        //获取变量中元素的个数
        Long zset7 = stringRedisTemplate.opsForZSet().zCard("zset");
        //修改变量中元素的分值
        Double score1 = stringRedisTemplate.opsForZSet().incrementScore("zset", "a", 2);
        //索引倒序排列指定区间的元素
        Set<String> zset8 = stringRedisTemplate.opsForZSet().reverseRange("zset", 1, 3);
        //倒序排列指定分值区间的元素
        Set<String> zset9 = stringRedisTemplate.opsForZSet().reverseRangeByScore("zset", 1, 3);
        //倒序排序获取RedisZSetCommands.Tuples的分值区间值
        Set<String> zset10 = stringRedisTemplate.opsForZSet().reverseRangeByScore("zset", 1, 3, 1, 2);
        //倒序排序获取RedisZSetCommands.Tuples的分值区间值。
        Set<ZSetOperations.TypedTuple<String>> zset11 = stringRedisTemplate.opsForZSet().reverseRangeByScoreWithScores("zset", 1, 5);
        /*assert zset != null;
        zset.iterator().forEachRemaining(e-> System.out.println(e.getValue() + "--->" + e.getScore()));*/
        //获取倒序排列的索引值
        Long aLong = stringRedisTemplate.opsForZSet().reverseRank("zset", "a");
        //获取2个变量的交集存放到第3个变量里面。
        Long aLong1 = stringRedisTemplate.opsForZSet().intersectAndStore("zset", "zset1", "zset2");
        //获取2个变量的合集存放到第3个变量里面。 返回操作的数量
        Long aLong3 = stringRedisTemplate.opsForZSet().unionAndStore("zset", "zset1", "zset2");
        //批量移除元素根据元素值。返回删除的元素数量
        Long remove = stringRedisTemplate.opsForZSet().remove("zset", "a", "b");
        //根据分值移除区间元素。返回删除的数量
        Long zset12 = stringRedisTemplate.opsForZSet().removeRangeByScore("zset", 1, 3);
        //据索引值移除区间元素。返回移除的元素集合
        Set<String> zset13 = stringRedisTemplate.opsForZSet().reverseRange("zset", 0, 4);

    }
}
