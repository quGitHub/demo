package cn.itcast.springboot.mybatis.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.itcast.springboot.mybatis.entity.Province;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/testRedis")
@Api(description = "redis操作")
public class RedisController {

	
	@Autowired
	private StringRedisTemplate strRedis;

    @Autowired
	private RedisTemplate redisTemplate;
	
	@ApiOperation("测试单个string类型查询")
    @GetMapping("/testRedis")
	@ResponseBody
    public String testRedis(@Param("key") String key, @Param("value") String value) {
        strRedis.opsForValue().set(key, value);
        String imooc_cache = strRedis.opsForValue().get(key);
        return imooc_cache;
    }




	@ApiOperation("测试list类型查询")
	@GetMapping("/testRedisList")
	@ResponseBody
	public  void  testRedisList() {
		strRedis.opsForList().leftPushAll("l2","v1","v2","v3","v4");
		List<String> list= strRedis.opsForList().range("l2", 0, -1);
		System.out.println(list.size());
	}

	@ApiOperation("测试list类型查询")
	@GetMapping("/testRedisHash")
	@ResponseBody
	public  void  testRedisHash() {
		Province province=new Province();
		province.setPid("cb2a70bd6c1b4608b4f237717bbbc9be");
		province.setProvince("广东");
		province.setProvinceTypes("40000");
		strRedis.opsForHash().hasKey("province",province);

		Province provinces = (Province) strRedis.opsForHash().get("province", province);
		/*String pid = (String) strRedis.opsForHash().get("province", province.getPid());
		String provinceTypes = (String) strRedis.opsForHash().get("province", province.getProvinceTypes());*/
		System.out.println("----:"+provinces.getProvince()+"======"+provinces.getPid()+"~~~~~~"+provinces.getProvinceTypes());
	}


	
	@ApiOperation("测试实体类")
    @GetMapping("/testRedisEntity")
	@ResponseBody
	public  void  testRedisEntity() {
		Province province=new Province();
		province.setPid("cb2a70bd6c1b4608b4f237717bbbc9be");
		province.setProvince("广东");
		province.setProvinceTypes("40000");
		redisTemplate.opsForValue().set("imooc_Province", province);

		String imooc_cache = strRedis.opsForValue().get("imooc_Province");
		System.out.println(imooc_cache);
	}
}