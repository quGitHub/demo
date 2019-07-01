package cn.itcast.springboot.mybatis.bean;

import cn.itcast.springboot.mybatis.entity.AliEntity;

public class test2 {

    public void test() {
        AliEntity aliEntity = new AliEntity();
        aliEntity.setDate("2019-06-26");
        aliEntity.setMeterMoney(20.36D);
        aliEntity.setPhoneNumbers("18838959376");
    }

}
