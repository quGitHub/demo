package test.service.impl;

import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;
import main.java.cn.itcast.springboot.mybatis.vo.base.ResultUtils;
import org.springframework.stereotype.Service;
import test.service.IAgentCarService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/8 15:05
 * @Description:
 */
@Service
public class AgentCarServiceImpl implements IAgentCarService {

    /**
     * 查询代理商车辆列表
     * @return
     */
    @Override
    public JsonList listAgentVehicle() {

        return ResultUtils.successJsonList();
    }
}
