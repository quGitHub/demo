package cn.hacz.edu.demo;
import java.math.BigDecimal;

import cn.itcast.springboot.mybatis.entity.ProvinceVo;
import org.junit.Test;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;*/
public class DemoApplicationTests {

	@Test
	public void test() {
		
		/*List<String> list=new ArrayList<String>();
		list.add("1111");
		list.add("2222");
		list.add("3333");
		boolean empty = CollectionUtils.isEmpty(list);
		System.out.println(empty);
		
		Map<Object,Object> map=new HashMap<>();
		
		boolean empty2 = CollectionUtils.isEmpty(map);
		System.out.println(empty2);*/
		

		BigDecimal b1=new BigDecimal("22.99");
		BigDecimal b2=new BigDecimal("22.86");
		//加
        BigDecimal add = b1.add(b2);
        System.out.println(add);

        //减
        /*BigDecimal divide = b1.divide(b2);
        System.out.println(divide);*/
        //乘
       BigDecimal divide = b1.divide(b2, 2,BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
        //除
        
      
           
	}

	/*@Test
	public void test2() {
		 Jedis jedis = new Jedis("192.168.28.128",6379);
		 String name = jedis.get("k1");
		 System.out.println(name);
    }
	*/
	/*@Autowired
    private StringRedisTemplate stringRedisTemplate;*/

   /* @Test
    public void save(){

        stringRedisTemplate.opsForValue().set("zzp","big z");
    }*/
	@Test
	public void test1(){

       ProvinceVo provinceVo=new ProvinceVo();
       provinceVo.setPid("");
       provinceVo.setProvince("");
       provinceVo.setProvinceTypes("");


       Admin admin=new Admin();
       admin.setId(0);
       admin.setName("");
       admin.setAge(0);
       admin.setSex("");
       admin.setPhone("");

	}



}