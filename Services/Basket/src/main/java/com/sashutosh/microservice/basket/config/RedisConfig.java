package com.sashutosh.microservice.basket.config;

import com.sashutosh.microservice.basket.model.IBasketRepository;
import com.sashutosh.microservice.basket.model.RedisBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;

@Configuration
@ComponentScan("com.sashutosh.microservice.basket")
//@EnableRedisRepositories(basePackages = "com.sashutosh.microservice.basket.model")
@PropertySource("classpath:application.properties")
public class RedisConfig {

    @Bean
    public SpringConfigHelper config()
    {
        return new SpringConfigHelper();
    }

   /* @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }*/

    @Autowired
    @Bean
    public Jedis getJedis(SpringConfigHelper config){
        return new Jedis(config.getHost(),config.getPort());
    }

    @Autowired
    @Bean
    public IBasketRepository basketRepository(){
        return new RedisBasketRepository();
    }



}