package test.controller;

import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.service.IAgentCarService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/8 14:57
 * @Description:
 */
@RequestMapping("/logistics/agentVehicle")
public class AgentCarController {


    @Autowired
    private IAgentCarService iAgentVehicleService;

    /**
     * 查询代理商车辆列表
     * @return
     */
    @ResponseBody
    @GetMapping("/listAgentVehicle")
    public JsonList listAgentVehicle(){

        JsonList jsonList = iAgentVehicleService.listAgentVehicle();
        return jsonList;
    }


}
