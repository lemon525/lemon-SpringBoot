package com.redis.Redis;


import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisList {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void redisList(){
        //在变量左边添加元素值。如果key不存在会新建，添加成功返回添加后的总个数
        Long leftPush = stringRedisTemplate.opsForList().leftPush("key","value");
        //向左边批量添加参数元素，如果key不存在会新建，添加成功返回添加后的总个数
        Long pushAll = stringRedisTemplate.opsForList().leftPushAll("key", "value1", "value2", "value3");
        //向集合最右边添加元素。如果key不存在会新建，添加成功返回添加后的总个数
        Long rightPush = stringRedisTemplate.opsForList().rightPush("key", "value4");
        //向右边批量添加参数元素，如果key不存在会新建，添加成功返回添加后的总个数
        Long pushAll2 = stringRedisTemplate.opsForList().rightPushAll("key", "value5", "value6", "value7");
        //向已存在的集合中添加元素。返回集合总元素个数 左边
        Long leftL = stringRedisTemplate.opsForList().leftPushIfPresent("key", "value");
        //向已存在的集合中添加元素。返回集合总元素个数 右边
        Long rightL = stringRedisTemplate.opsForList().rightPushIfPresent("key", "value");
        //获取集合长度
        Long size = stringRedisTemplate.opsForList().size("key");
        //移除集合中的左边第一个元素。返回删除的元素，如果元素为空，该集合会自动删除
        String leftPop = stringRedisTemplate.opsForList().leftPop("key");
        //移除集合中右边的元素。返回删除的元素，如果元素为空，该集合会自动删除
        String rightPop = stringRedisTemplate.opsForList().rightPop("key");
        //移除集合中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
        String leftstr = stringRedisTemplate.opsForList().leftPop("key", 10, TimeUnit.SECONDS);
        //移除集合中右边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
        String rightstr = stringRedisTemplate.opsForList().rightPop("key", 10, TimeUnit.SECONDS);
        //移除第一个集合右边的一个元素，插入第二个集合左边插入这个元素
        String s = stringRedisTemplate.opsForList().rightPopAndLeftPush("key", "key1");
        //在集合的指定位置插入元素,如果指定位置已有元素，则覆盖，没有则新增，超过集合下标+n则会报错。
        stringRedisTemplate.opsForList().set("key", 2, "value11");
        //从存储在键中的列表中删除等于值的元素的第一个计数事件。count> 0：删除等于从左到右移动的值的第一个元素；
        //count< 0：删除等于从右到左移动的值的第一个元素；count = 0：删除等于value的所有元素
        Long remove = stringRedisTemplate.opsForList().remove("key", 2, "value12");
        //截取集合元素长度，保留长度内的数据。
        stringRedisTemplate.opsForList().trim("key", 0, 3);
        //获取集合指定位置的值。
        Object listValue = stringRedisTemplate.opsForList().index("key", 3);
        //获取指定区间的值
        List<String> list = stringRedisTemplate.opsForList().range("key", 0, -1);
        //删除指定集合,返回true删除成功
        Boolean delete = stringRedisTemplate.opsForList().getOperations().delete("key");
    }
}
