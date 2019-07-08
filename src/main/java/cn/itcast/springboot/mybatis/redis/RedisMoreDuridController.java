package cn.itcast.springboot.mybatis.redis;

import io.swagger.annotations.Api;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@RestController
@RequestMapping("/testRedisDurid")
@Api(description = "redis操作")
public class RedisMoreDuridController {

    @Resource(name = "defaultRedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "redisTemplate1")
    private RedisTemplate<String, Object> redisTemplate1;

    @Resource(name = "redisTemplate2")
    private RedisTemplate<String, Object> redisTemplate2;

    @GetMapping("test")
    public void stringRedisTest() {
        redisTemplate.opsForValue().set("cccc", "44444");
        redisTemplate.opsForValue().set("cccc", "55555");
        String k1 = (String) redisTemplate1.opsForValue().get("cccc");
        String k2 = (String) redisTemplate2.opsForValue().get("cccc");
        System.out.println(k1);
        System.out.println(k2);
    }
}