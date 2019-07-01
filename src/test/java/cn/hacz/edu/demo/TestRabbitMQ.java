package cn.hacz.edu.demo;
import cn.itcast.springboot.mybatis.rabbitMQ.Order;
import cn.itcast.springboot.mybatis.rabbitMQ.SendSms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRabbitMQ {

    @Autowired
    private SendSms  sendSms;

    @Test
    public  void  testRabbitMq(){
        Order order=new  Order();
        order.setId(122);
        order.setName("张三");
        order.setMessageId(System.currentTimeMillis()+"$"+UUID.randomUUID().toString().replaceAll("-",""));
        sendSms.sendSms(order);
    }


}
