package test.service.impl;
import cn.itcast.springboot.mybatis.vo.base.JsonList;
import cn.itcast.springboot.mybatis.vo.base.ResultUtils;
import org.springframework.stereotype.Service;
import test.service.ICarDetailsService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 10:52
 * @Description:
 */
@Service
public class CarDetailsServiceImpl implements ICarDetailsService {

    /**
     * 查询车辆详情
     * @return
     */
    @Override
    public JsonList listVehicleDetails() {
        JsonList jsonList = ResultUtils.successJsonList();
        return jsonList;
    }

    /**
     * 查询绑定卡信息
     * @return
     */
    @Override
    public JsonList listBindingCard() {
        JsonList jsonList = ResultUtils.successJsonList();
        return jsonList;
    }
}