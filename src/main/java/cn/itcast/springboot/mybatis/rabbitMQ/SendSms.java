package cn.itcast.springboot.mybatis.rabbitMQ;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendSms {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendSms(Order order) {

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());

        rabbitTemplate.convertSendAndReceive("order-exchange",//exchange
                "order.abcd",   // 路由规则
                order,            //消息体内容
                correlationData     //correlationData  消息唯一ID
        );
    }


}
