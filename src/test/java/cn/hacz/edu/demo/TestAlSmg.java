package cn.hacz.edu.demo;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestAlSmg {

    // 产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";

    // 产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIcGbIVujWXqbs";         // TODO 改这里

    static final String accessKeySecret = "QX6KCkquM42CFBljYnTySZlEmJ2RFl"; // TODO 改这里

    public static SendSmsResponse sendSms(String telephone, String meterNumber,int meterMoney) throws ClientException {

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
        request.setPhoneNumbers(telephone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName("百利威智慧园区"); // TODO 改这里
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("尊敬的客户您好:你使用的表号为${meterNumber}的电表,截至目前余额为${meterMoney}元，请你及充值，避免欠费给你带来不必要麻烦。");  // TODO 改这里
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的用户,你的电费现在还有0.58元，请你及时去冲电费，
        // 避免欠费给你带来不必要麻烦}"时,此处的值为
        request.setTemplateParam("{\"meterNumber\":\"" + meterNumber + "\",\"meterMoney\":\"" + meterMoney + "\"}"); // TODO 改这里

        // 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");

        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        // hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("短信发送成功！");
        } else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }


    public static void main(String[] args) throws Exception {
        //填写你需要测试的手机号码， 现在电表费用
        SendSmsResponse sendSms = sendSms("18838959376", "BLW1254785",1);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + sendSms.getCode()); //状态码-返回OK代表请求成功,其他错误码详见错误码列表
        System.out.println("Message=" + sendSms.getMessage());  //状态码的描述
        System.out.println("RequestId=" + sendSms.getRequestId());  //	请求ID
        System.out.println("BizId=" + sendSms.getBizId());  //发送回执ID,可根据该ID查询具体的发送状态

    }

}
