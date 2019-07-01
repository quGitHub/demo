package test.service.impl;

import main.java.cn.itcast.springboot.mybatis.vo.base.Json;
import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;
import main.java.cn.itcast.springboot.mybatis.vo.base.ResultUtils;
import org.springframework.stereotype.Service;
import test.service.ICarGroupService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 10:21
 * @Description:
 */
@Service
public class CarGroupServiceImpl implements ICarGroupService {

    /**
    * 添加车队
    * @return
    */
    @Override
    public Json addVehicleGroup() {
        //判断必填字段是否为空
        //判断编组
        Json json= ResultUtils.successJsonList();
        return json;
    }


    /**
     * 查询车辆列表
     * @return
     */
    @Override
    public JsonList listVehicleGroup() {
        JsonList jsonList = ResultUtils.successJsonList();
        return jsonList;
    }


    /**
     * 修改车辆编组信息
     * @return
     */
    @Override
    public Json updateVehicleGroup() {
        Json json= ResultUtils.successJsonList();
        return json;
    }

    /**
     * 根据物流企业查询所有车辆信息
     */
    @Override
    public JsonList listLogisticsCompanyBelowVehicle(){
        //判断参数是否为空

        //判断根据物流企业id查询下面所有车辆

        return ResultUtils.successJsonList();
    }

    /**
     * 根据车辆id查询车辆信息
     * @return
     */
    @Override
    public Json getVehicleInfo(){
        //判断参数是否为空

        //根据车辆id查询车辆信息

        return ResultUtils.successJson();
    }

}