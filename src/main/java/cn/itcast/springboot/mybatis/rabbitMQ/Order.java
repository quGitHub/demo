package cn.itcast.springboot.mybatis.rabbitMQ;


import java.io.Serializable;

//实现序列化
public class Order implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private Integer id;

    private String name;

    private String messageId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
