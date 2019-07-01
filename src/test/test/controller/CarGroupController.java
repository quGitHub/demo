package test.controller;

import main.java.cn.itcast.springboot.mybatis.vo.base.Json;
import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.service.ICarGroupService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 10:17
 * @Description:  车辆组队
 */
@ResponseBody
@RequestMapping("/logistics/vehicleGroup")
public class CarGroupController {

      @Autowired
      private ICarGroupService iVehicleGroupService;

    /**
     * 添加车辆编组
     * @return
     */
      @PostMapping("/addVehicleGroup")
      @ResponseBody
      public Json addVehicleGroup(){
          Json json = iVehicleGroupService.addVehicleGroup();
          return json;
      }

    /**
     * 车辆编组查询
     * @return
     */
      @GetMapping("/listVehicleGroup")
      @ResponseBody
      public JsonList listVehicleGroup() {
          JsonList jsonList = iVehicleGroupService.listVehicleGroup();
          return jsonList;
      }


    /**
     * 修改车辆编组信息
     */
    @PostMapping("/updateVehicleGroup")
    @ResponseBody
    public Json updateVehicleGroup(){
        Json json = iVehicleGroupService.updateVehicleGroup();
        return json;
    }

    /**
     * 根据物流企业查询下面车辆
     */
    @GetMapping("/listLogisticsCompanyBelowVehicle")
    @ResponseBody
    public Json listLogisticsCompanyBelowVehicle(){
        Json json = iVehicleGroupService.listLogisticsCompanyBelowVehicle();
        return json;
    }

    /**
     * 根据车辆id查询车辆信息
     */
    @GetMapping("/getVehicleInfo")
    @ResponseBody
    public Json getVehicleInfo(){
        Json json = iVehicleGroupService.getVehicleInfo();
        return json;
    }
}