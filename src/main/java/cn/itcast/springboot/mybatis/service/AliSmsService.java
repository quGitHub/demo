package cn.itcast.springboot.mybatis.service;
import cn.itcast.springboot.mybatis.controller.ProvinceController;
import cn.itcast.springboot.mybatis.entity.AliEntity;
import cn.itcast.springboot.mybatis.entity.SmsEntity;
import cn.itcast.springboot.mybatis.mapper.SmsMapper;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AliSmsService {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);


    @Autowired
    private SmsMapper smsMapper;

    // 产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";

    // 产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIcGbIVujWXqbs";         // TODO 改这里

    static final String accessKeySecret = "QX6KCkquM42CFBljYnTySZlEmJ2RFl"; // TODO 改这里


    public SendSmsResponse sendRechargeSms(AliEntity aliEntity) throws ClientException {

        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");

        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // 初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);

        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        // 必填:待发送手机号
        request.setPhoneNumbers(aliEntity.getPhoneNumbers());
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName("百利威智慧园区"); // TODO 改这里
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(AliSmsService.setTemplateCode(aliEntity));  // TODO 改这里
        // 可选:模板中的变量替换JSON串
        AliSmsService.setPrama(request,aliEntity);

        // 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");

        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        // hint 此处可能会抛出异常，注意catch
        //SendSmsResponse sendSmsResponse=null;
         SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        SmsEntity smsEntity=new  SmsEntity();
        smsEntity.setSendPhone(aliEntity.getPhoneNumbers());//手机号
        smsEntity.setCardNo(aliEntity.getMeterNumber());//表号

        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            smsEntity.setIsSuccess(1); //成功
        } else {
            smsEntity.setIsSuccess(2); //失败
            smsEntity.setErrorCode(sendSmsResponse.getCode());
        }
        smsMapper.insertSms(smsEntity);//插入数据

        return sendSmsResponse;
    }



    //设置参数
    private static void  setPrama(SendSmsRequest request, AliEntity aliEntity){
         //表示充值
        if(aliEntity.getTemplateType()==1){
            request.setTemplateParam("{\"meterNumber\":\"" + aliEntity.getMeterNumber() + "\",\"date\":\"" + aliEntity.getDate()
                    + "\",\"meterMoney\":\"" + aliEntity.getMeterMoney() + "\"}");
        }else if(aliEntity.getTemplateType()==2){//电费提醒
            request.setTemplateParam("{\"meterNumber\":\"" + aliEntity.getMeterNumber() + "\",\"meterMoney\":\"" + aliEntity.getMeterMoney() + "\"}");
        }
    }

    //设置短信模板码
    private static String setTemplateCode(AliEntity aliEntity){
        String templateCode=null;
        if(aliEntity.getTemplateType()==1){
            templateCode="SMS_166475809";
        }else if(aliEntity.getTemplateType()==2){//电费提醒
            templateCode="SMS_166475711";
        }
        return templateCode;
    }
}
