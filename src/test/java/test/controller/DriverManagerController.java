package test.controller;

import cn.itcast.springboot.mybatis.entity.RmsDriverVo;
import cn.itcast.springboot.mybatis.vo.base.Json;
import cn.itcast.springboot.mybatis.vo.base.JsonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.service.IDriverManagerService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 9:31
 * @Description:  司机管理
 */
@RequestMapping("/logistics/driver")
@RestController
public class DriverManagerController {

       @Autowired
       private IDriverManagerService iDriverManagerService;


    /**
     * 获取客户信息
     * @return
     */
      @ResponseBody
      @GetMapping("/listCustomerName")
      public JsonList listCustomerName(RmsDriverVo rmsDriverVo){
          JsonList jsonList = iDriverManagerService.listCustomerName(rmsDriverVo);
          return jsonList;
      }

     /**
      *  添加司机
      * @return
      */
       @ResponseBody
       @PostMapping("/addDriver")
       public Json addDriver(RmsDriverVo rmsDriverVo){
           Json json = iDriverManagerService.addDriver(rmsDriverVo);
           return json;
       }


    /**
     * 查询司机信息列表
     */
      @ResponseBody
      @GetMapping("/listDriverInfo")
      public JsonList  listDriverInfo(RmsDriverVo rmsDriverVo){
          JsonList jsonList = iDriverManagerService.listDriverInfo(rmsDriverVo);
          return jsonList;
      }

     /**
      * 修改司机信息
      */
      @ResponseBody
      @PostMapping("/updateDriverInfo")
      public Json  updateDriverInfo(RmsDriverVo rmsDriverVo){
        Json json= iDriverManagerService.updateDriverInfo(rmsDriverVo);
        return json;
      }

    /**
     * 司机状态停用
     */
    @ResponseBody
    @PostMapping("/driverStatusQuit")
    public Json  driverStatusQuit(String certNum){
        Json json= iDriverManagerService.driverStatusQuit(certNum);
        return json;
    }

    /**
     * 司机状态启用
     */
    @ResponseBody
    @PostMapping("/driverStatusStart")
    public Json  driverStatusStart(String certNum){
        Json json= iDriverManagerService.driverStatusStart(certNum);
        return json;
    }

}
