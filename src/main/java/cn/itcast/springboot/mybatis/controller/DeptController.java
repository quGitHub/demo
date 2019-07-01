package cn.itcast.springboot.mybatis.controller;

import cn.itcast.springboot.mybatis.entity.Dept;
import cn.itcast.springboot.mybatis.entity.SmsEntity;
import cn.itcast.springboot.mybatis.mapper.DeptMapper;
import cn.itcast.springboot.mybatis.service.ProvinceService;
import cn.itcast.springboot.mybatis.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2019/1/31 16:32
 * @Description:
 */
@RestController
public class DeptController {

    @Autowired
    private DeptMapper  deptMapper;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/findAll")
    @ResponseBody
    public Message  findAll(int id){
        Message message=new Message();
        Dept dept = deptMapper.findAll(id);
        message.setDate(dept);
        message.setSuccess(true);
        return message;
    }

    @GetMapping("/test")
    @ResponseBody
    public  SmsEntity  test() throws Exception {
        SmsEntity smsEntity=new  SmsEntity();
        smsEntity.setSendPhone("18823654589");
        smsEntity.setCardNo("pwe125698");
        smsEntity.setIsSuccess(1);
        doTaskOne();
        return smsEntity;
    }


    @GetMapping("/test1")
    @ResponseBody
    public SmsEntity test1() throws Exception {
        SmsEntity smsEntity =doTaskOne();
        return smsEntity;
    }


    @RequestMapping("/async")
    public String async(){
        System.out.println("####IndexController####   1");
        provinceService.sendSms();
        System.out.println("####IndexController####   4");
        return "success";
    }

    @Async
    public SmsEntity doTaskOne() throws Exception {
        SmsEntity smsEntity=new  SmsEntity();
        smsEntity.setSendPhone("18823654589");
        smsEntity.setCardNo("pwe125698");
        smsEntity.setIsSuccess(1);
        return smsEntity;
    }



}
