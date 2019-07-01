package cn.itcast.springboot.mybatis.controller;

import cn.itcast.springboot.mybatis.rabbitMQ.Order;
import cn.itcast.springboot.mybatis.rabbitMQ.SendSms;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/rabbitMq")
@Api(description = "RabbitMQ测试")
public class RabbitMQController {


    @Autowired
    private SendSms sendSms;

    @GetMapping("/test")
    @ResponseBody
    public  void  testRabbitMq(){
        Order order=new  Order();
        order.setId(1);
        order.setName("张三");
        order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString().replaceAll("-",""));
        sendSms.sendSms(order);
    }
}
