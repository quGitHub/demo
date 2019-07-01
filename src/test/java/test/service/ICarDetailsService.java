package test.service;

import cn.itcast.springboot.mybatis.vo.base.Json;
import cn.itcast.springboot.mybatis.vo.base.JsonList;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 10:49
 * @Description:
 */
public interface ICarDetailsService {

    /**
     * 查询车辆详情
     * @return
     */
    public JsonList listVehicleDetails();

    /**
     * 查询绑定卡信息
     * @return
     */
    public JsonList listBindingCard();

    
}
