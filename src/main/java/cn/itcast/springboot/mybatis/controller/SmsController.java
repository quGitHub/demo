package cn.itcast.springboot.mybatis.controller;
import cn.itcast.springboot.mybatis.entity.AliEntity;
import cn.itcast.springboot.mybatis.mapper.SmsMapper;
import cn.itcast.springboot.mybatis.service.AliSmsService;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/smsController")
public class SmsController {


    @Autowired
    private AliSmsService aliSms;

    @Autowired
    private SmsMapper smsMapper;

    //电费充值
    @ResponseBody
    @PostMapping("/sendRecharge")
    public  SendSmsResponse sendRechargeSms(@RequestBody  AliEntity aliEntity) throws ClientException {
        SendSmsResponse sendSmsResponse = aliSms.sendRechargeSms(aliEntity);
        return sendSmsResponse;
    }


    @ResponseBody
    @PostMapping("/test")
    public  void  test(  ) throws ClientException {
       /* SmsEntity  smsEntity=new  SmsEntity();
        smsEntity.setSendPhone("18823654589");
        smsEntity.setCardNo("pwe125698");
        smsEntity.setIsSuccess(1);
        smsMapper.insertSms(smsEntity);*/
    }


}
