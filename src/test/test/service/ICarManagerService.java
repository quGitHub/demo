package test.service;

import main.java.cn.itcast.springboot.mybatis.vo.base.Json;
import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 9:52
 * @Description:
 */
public interface ICarManagerService {

    public Json addVehicle();

    public JsonList listVehicleInfo();

    public Json updateVehicleInfo();

    public JsonList listLogisticsCompanyBelowDriver();

    public Json  getDriverInfo();

    public Json  updateCarToDriverInfo();


    public Json  vehicleStatusQuit();

    public Json  vehicleStatusStart();

    public Json  getVehicleDetailsInfo();
}
