package com.redis.jedis;


import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@Slf4j
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.timeout}")
    private Integer timeout;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private Integer database;


    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private Long maxWait;

    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;

    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer minIdle;


    @Bean
    public JedisPool redisPoolFactory()  throws Exception{
        log.info("JedisPool注入成功！！");
        log.info(maxActive.toString());
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        //最小空闲的连接数
        jedisPoolConfig.setMaxIdle(maxIdle);
        //连接池最大连接数
        jedisPoolConfig.setMaxTotal(maxActive);
        //连接池最大阻塞等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        //连接池最小空闲的连接数
        jedisPoolConfig.setMinIdle(minIdle);
        if(StringUtils.isBlank(password)){
            //判断密码是否为空 不判断会报错
            //Could not get a resource from the pool
            return new JedisPool(jedisPoolConfig, host, port, timeout, null,database);
        }
        return new JedisPool(jedisPoolConfig, host, port, timeout, password,database);
    }
}
