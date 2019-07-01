package test.controller;

import cn.itcast.springboot.mybatis.vo.base.JsonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.service.ICarDetailsService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 10:47
 * @Description:  车辆概论
 */
@RequestMapping("/logistics/vehicleDatail")
public class CarDetailsController {

    @Autowired
    private ICarDetailsService iVehicleDetailsService;


    /**
     * 查询车辆概览
     * @return
     */
    @GetMapping("/listVehicleDetails")
    @ResponseBody
    public JsonList listVehicleDetails(){
        JsonList jsonList = iVehicleDetailsService.listVehicleDetails();
        return jsonList;
    }


    /**
     * 查询绑定卡列表
     * @return
     */
    @GetMapping("/listVehicleBindCardInfo")
    @ResponseBody
    public JsonList listbindingCard(){
        JsonList jsonList = iVehicleDetailsService.listBindingCard();
        return jsonList;
    }

}
