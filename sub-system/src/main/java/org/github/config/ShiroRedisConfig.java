package org.github.config;

import org.apache.shiro.spring.config.web.autoconfigure.ShiroWebAutoConfiguration;
import org.crazycake.shiro.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import static org.apache.commons.lang3.StringUtils.*;

@Configuration
@PropertySource("classpath:shiro-redis.properties")
@EnableConfigurationProperties({RedisManagerProperties.class, CacheManagerProperties.class, RedisSessionDAOProperties.class})
@ConditionalOnProperty(name = "shiro-redis.enabled", matchIfMissing = true)
@EnableAutoConfiguration(exclude = ShiroRedisAutoConfiguration.class)
@AutoConfigureBefore({ShiroWebAutoConfiguration.class})
public class ShiroRedisConfig {
  @Autowired
  private RedisManagerProperties redisManagerProperties;

  @Autowired
  private CacheManagerProperties cacheManagerProperties;

  @Autowired
  private RedisSessionDAOProperties redisSessionDAOProperties;

  @Bean
  public RedisCacheManager cacheManager(IRedisManager redisManager) {
    RedisCacheManager cacheManager = new RedisCacheManager();
    cacheManager.setRedisManager(redisManager);
    if (isNotBlank(cacheManagerProperties.getPrincipalIdFieldName())) cacheManager.setPrincipalIdFieldName(cacheManagerProperties.getPrincipalIdFieldName());
    if (cacheManagerProperties.getExpire() != null) cacheManager.setExpire(cacheManagerProperties.getExpire());
    if (isNotBlank(cacheManagerProperties.getKeyPrefix())) cacheManager.setKeyPrefix(cacheManagerProperties.getKeyPrefix());
    return cacheManager;
  }

  @Bean
  @ConditionalOnMissingBean
  public IRedisManager redisManager() {
    IRedisManager redisManager = null;
    if ("standalone".equals(redisManagerProperties.getDeployMode())) redisManager = createStandaloneRedisManager();
    if ("sentinel".equals(redisManagerProperties.getDeployMode())) redisManager = createRedisSentinelManager();
    if ("cluster".equals(redisManagerProperties.getDeployMode())) redisManager = createRedisClusterManager();
    return redisManager;
  }

  private IRedisManager createStandaloneRedisManager() {
    IRedisManager redisManager;
    RedisManager  standaloneManager = new RedisManager();
    if (isNotBlank(redisManagerProperties.getHost())) standaloneManager.setHost(redisManagerProperties.getHost());
    if (redisManagerProperties.getTimeout() != null) standaloneManager.setTimeout(redisManagerProperties.getTimeout());
    if (isNotBlank(redisManagerProperties.getPassword())) standaloneManager.setPassword(redisManagerProperties.getPassword());
    if (redisManagerProperties.getDatabase() != null) standaloneManager.setDatabase(redisManagerProperties.getDatabase());
    if (redisManagerProperties.getCount() != null) standaloneManager.setCount(redisManagerProperties.getCount());
    redisManager = standaloneManager;
    return redisManager;
  }

  private IRedisManager createRedisSentinelManager() {
    IRedisManager        redisManager;
    RedisSentinelManager sentinelManager = new RedisSentinelManager();
    if (isNotBlank(redisManagerProperties.getHost())) sentinelManager.setHost(redisManagerProperties.getHost());
    if (redisManagerProperties.getTimeout() != null) sentinelManager.setTimeout(redisManagerProperties.getTimeout());
    if (isNotBlank(redisManagerProperties.getMasterName())) sentinelManager.setMasterName(redisManagerProperties.getMasterName());
    if (redisManagerProperties.getSoTimeout() != null) sentinelManager.setSoTimeout(redisManagerProperties.getSoTimeout());
    if (isNotBlank(redisManagerProperties.getPassword())) sentinelManager.setPassword(redisManagerProperties.getPassword());
    if (redisManagerProperties.getDatabase() != null) sentinelManager.setDatabase(redisManagerProperties.getDatabase());
    if (redisManagerProperties.getCount() != null) sentinelManager.setCount(redisManagerProperties.getCount());
    redisManager = sentinelManager;
    return redisManager;
  }

  private IRedisManager createRedisClusterManager() {
    IRedisManager       redisManager;
    RedisClusterManager clusterManager = new RedisClusterManager();
    if (isNotBlank(redisManagerProperties.getHost())) clusterManager.setHost(redisManagerProperties.getHost());
    if (redisManagerProperties.getTimeout() != null) clusterManager.setTimeout(redisManagerProperties.getTimeout());
    if (redisManagerProperties.getSoTimeout() != null) clusterManager.setSoTimeout(redisManagerProperties.getSoTimeout());
    if (redisManagerProperties.getMaxAttempts() != null) clusterManager.setMaxAttempts(redisManagerProperties.getMaxAttempts());
    if (isNotBlank(redisManagerProperties.getPassword())) clusterManager.setPassword(redisManagerProperties.getPassword());
    if (redisManagerProperties.getDatabase() != null) clusterManager.setDatabase(redisManagerProperties.getDatabase());
    if (redisManagerProperties.getCount() != null) clusterManager.setCount(redisManagerProperties.getCount());
    redisManager = clusterManager;
    return redisManager;
  }

  @Bean
  public RedisSessionDAO sessionDAO(IRedisManager redisManager) {
    RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
    redisSessionDAO.setRedisManager(redisManager);
    if (redisSessionDAOProperties.getExpire() != null) redisSessionDAO.setExpire(redisSessionDAOProperties.getExpire());
    if (isNotBlank(redisSessionDAOProperties.getKeyPrefix())) redisSessionDAO.setKeyPrefix(redisSessionDAOProperties.getKeyPrefix());
    if (redisSessionDAOProperties.getSessionInMemoryTimeout() != null) redisSessionDAO.setSessionInMemoryTimeout(redisSessionDAOProperties.getSessionInMemoryTimeout());
    return redisSessionDAO;
  }
}
