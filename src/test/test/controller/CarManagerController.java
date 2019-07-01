package test.controller;
import main.java.cn.itcast.springboot.mybatis.vo.base.Json;
import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.service.ICarManagerService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 9:30
 * @Description:  车辆管理
 */
@RequestMapping("/logistics/vehicle")
@RestController
public class CarManagerController {


      @Autowired
      private ICarManagerService iVehicleManagerService;

    /**
     * 添加车辆信息
     * @return
     */
      @PostMapping("/addVehicle")
      @ResponseBody
      public Json addVehicle(){
          Json json = iVehicleManagerService.addVehicle();
          return json;
      }

    /**
     * 查询车辆信息列表
     */
     @GetMapping("/listVehicleInfo")
     @ResponseBody
     public JsonList listVehicleInfo(){
         JsonList jsonList = iVehicleManagerService.listVehicleInfo();
         return jsonList;
     }

    /**
     * 修改车辆信息
     */
     @PostMapping("/updateVehicleInfo")
     @ResponseBody
     public Json updateVehicleInfo(){
         Json json=iVehicleManagerService.updateVehicleInfo();
         return json;
     }


    /**
     * 查询物流企业下面司机
     */
    @GetMapping("/listLogisticsCompanyBelowDriver")
    @ResponseBody
    public JsonList listLogisticsCompanyBelowDriver(){
        JsonList json=iVehicleManagerService.listLogisticsCompanyBelowDriver();
        return json;
    }


    /**
     * 根据司机id查询司机信息
     */
    @GetMapping("/getDriverInfo")
    @ResponseBody
    public Json  getDriverInfo(){
        Json json=iVehicleManagerService.getDriverInfo();
        return json;
    }


    /**
     * 删除车辆下面某个司机
     */
    @GetMapping("/updateCarToDriverInfo")
    @ResponseBody
    public Json  updateCarToDriverInfo(){
        Json json=iVehicleManagerService.updateCarToDriverInfo();
        return json;
    }

    /**
     * 车辆状态停止
     */
    @GetMapping("/vehicleStatusQuit")
    @ResponseBody
    public Json  VehicleStatusQuit(){
        Json json=iVehicleManagerService.vehicleStatusQuit();
        return json;
    }

    /**
     * 车辆状态启用
     * @return
     */
    @GetMapping("/vehicleStatusStart")
    @ResponseBody
    public Json  vehicleStatusStart(){
        Json json=iVehicleManagerService.vehicleStatusStart();
        return json;
    }




    @GetMapping("/getVehicleDetailsInfo")
    @ResponseBody
    public Json  getVehicleDetailsInfo(){
        Json json=iVehicleManagerService.getVehicleDetailsInfo();
        return json;
    }
}
