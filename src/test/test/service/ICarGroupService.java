package test.service;
import main.java.cn.itcast.springboot.mybatis.vo.base.Json;
import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;
/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 10:18
 * @Description:
 */
public interface ICarGroupService {
    public Json addVehicleGroup();

    public JsonList listVehicleGroup();

    public Json updateVehicleGroup();

    public Json listLogisticsCompanyBelowVehicle();

    public Json getVehicleInfo();
}