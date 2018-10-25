package com.github.openstore.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2018-10-25
 **/
@Configuration
//@EnableCaching
public class RedisConfig {
    //@Value("${redis.cache.expiration:3600}")
    //private Long expiration;

    /*@Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        rcm.setDefaultExpiration(expiration);
        return rcm;
    }*/

    @Resource
    private LettuceConnectionFactory myLettuceConnectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> rt = new RedisTemplate<>();
        rt.setKeySerializer(new StringRedisSerializer());
        rt.setConnectionFactory(myLettuceConnectionFactory);
        rt.setValueSerializer(new JdkSerializationRedisSerializer());
        return rt;
    }
}