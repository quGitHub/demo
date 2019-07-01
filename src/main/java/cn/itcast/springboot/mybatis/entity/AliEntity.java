package cn.itcast.springboot.mybatis.entity;

public class AliEntity {

    //手机号
    private String phoneNumbers;

    //模板类型  1: 电费充值  2: 电费提醒
    private Integer templateType;

    //电表号
    private String  meterNumber;
    //时间
    private String  date;
    //充值金额
    private Double meterMoney;

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMeterMoney() {
        return meterMoney;
    }

    public void setMeterMoney(Double meterMoney) {
        this.meterMoney = meterMoney;
    }
}
