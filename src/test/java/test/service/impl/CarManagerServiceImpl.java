package test.service.impl;
import cn.itcast.springboot.mybatis.vo.base.Json;
import cn.itcast.springboot.mybatis.vo.base.JsonList;
import cn.itcast.springboot.mybatis.vo.base.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.service.ICarManagerService;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 9:55
 * @Description: 车辆信息操作
 */
@Service
public class CarManagerServiceImpl implements ICarManagerService {


    /**
     * 添加车辆
     * @return
     */
    @Override
    @Transactional
    public Json addVehicle() {
        //1:判断必填参数是否为空

        //2:判断车牌号和车牌颜色是否在数据库已经存在

        //3:把车辆信息与物流企业(物流企业id)绑定,保存到车辆表,并且返回车辆id。

        /**
         * 4: 判断司机id是否为空
         *  空： 不插入车辆信息
         *  非空：把车辆与司机进行绑定,保存车辆与司机中间表中去  批量插入
         */
        return ResultUtils.successJson();
    }

    /**
     * 查询车辆列表器
     * @return
     */
    @Override
    public JsonList listVehicleInfo() {
        JsonList jsonList= ResultUtils.successJsonList();
        return jsonList;
    }


    /**
     * 更新车辆信息
     * @return
     */
    @Override
    @Transactional
    public Json updateVehicleInfo() {
        //判断参数是否为空。

        //根据车辆id判断车辆是否存在。

        //修改车辆信息,保存到表中。

        //添加车辆与与某一个司机绑定关系,保存到表中。

        return ResultUtils.successJson();
    }


    /**
     * 查询物流企业下面所有司机
     * @return
     */
    @Override
    public JsonList listLogisticsCompanyBelowDriver() {
        //判断参数是否为空

        //根据物流企业id查询他下面所有司机

        return ResultUtils.successJsonList();
    }


    /**
     * 根据司机id查询司机信息
     * @return
     */
    @Override
    public Json getDriverInfo() {
        //判断参数是否为空

        //根据司机id查询司机信息

        return ResultUtils.successJson();
    }

    /**
     * 根据司机id删除车辆与司机之间关系
     * @return
     */
    @Override
    public Json  updateCarToDriverInfo(){
        //判断参数是否为空

        //根据司机id与车辆id查询车辆与司机中间表信息

        //如果存在,把该条信息remove=0

        return ResultUtils.successJson();
    }


    /**
     * 车辆停用状态
     * @return
     */
    @Override
    public Json vehicleStatusQuit() {
        return ResultUtils.successJson();
    }


    /***
     * 车辆状态启用
     * @return
     */
    @Override
    public Json vehicleStatusStart() {
        return  ResultUtils.successJson();
    }


    /**
     * 查看车辆详细信息
     * @return
     */
    @Override
    public Json getVehicleDetailsInfo() {
        return ResultUtils.successJson();
    }

}