package cn.itcast.springboot.mybatis.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * * llld-parent 配置默认Redis操作实例 到Spring中
 * quziyaun
 */

@EnableCaching
@Configuration
public class DefaultRedisConfig extends RedisConfig {

    @Value("${spring.redis.database}")
    private int dbIndex;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    /**
     * 配置redis连接工厂
     *
     * @return
     */
    @Bean
    public RedisConnectionFactory defaultRedisConnectionFactory() {
        return createJedisConnectionFactory(dbIndex, host, port, timeout);
    }

    /**
     * 配置redisTemplate 注入方式使用@Resource(name="") 方式注入
     *
     * @return
     */
    @Bean(name = "defaultRedisTemplate")
    public RedisTemplate defaultRedisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(defaultRedisConnectionFactory());
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }

}
