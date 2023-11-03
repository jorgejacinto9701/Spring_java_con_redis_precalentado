package com.centroinformacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

	
  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
    redisConfiguration.setHostName("localhost");
    redisConfiguration.setPort(6379);
    //disConfiguration.setDatabase(database);
    //redisConfiguration.setPassword(RedisPassword.of(password));

    JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
    //jedisClientConfiguration.connectTimeout(Duration.ofMillis(Long.parseLong("1000")));

    return new JedisConnectionFactory(redisConfiguration, jedisClientConfiguration.build());
  }

  @Bean
  RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
  }
  

  
  
}