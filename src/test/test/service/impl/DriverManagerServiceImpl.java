package test.service.impl;
import main.java.cn.itcast.springboot.mybatis.entity.TbRmsDriver;
import main.java.cn.itcast.springboot.mybatis.entity.RmsDriverVo;
import main.java.cn.itcast.springboot.mybatis.entity.TbRmsCustomerDriver;
import main.java.cn.itcast.springboot.mybatis.utils.MyBeanUtils;
import main.java.cn.itcast.springboot.mybatis.vo.base.Json;
import main.java.cn.itcast.springboot.mybatis.vo.base.JsonList;
import main.java.cn.itcast.springboot.mybatis.vo.base.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.service.IDriverManagerService;
import java.util.Date;
/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 9:36
 * @Description:  司机管理列表
 */
@Service
public class DriverManagerServiceImpl implements IDriverManagerService {
    /**
     * 保存司机信息
     * @return
     */
    @Override
    @Transactional
    public Json addDriver(RmsDriverVo rmsDriverVo) {
        //判断必填参数是否为空
       if(StringUtils.isEmpty(rmsDriverVo.getCertNum())
               &&StringUtils.isEmpty(rmsDriverVo.getTelephone())&&StringUtils.isEmpty(rmsDriverVo.getDriverName())){
            ResultUtils.errorJson("100","必填参数为空");
        }
        //判断司机是否存在
        TbRmsDriver  iscertNumEmpty= iscertNumEmpty(rmsDriverVo.getCertNum());
        if(iscertNumEmpty!=null){
            ResultUtils.errorJson("100","司机已存在");
        }
        //保存司机信息,默认为启用状态，remove=0,返回司机id。
        TbRmsDriver tbRmsDriver=new TbRmsDriver();
        MyBeanUtils.copyWithNullStringToEmpty(tbRmsDriver,rmsDriverVo);
        tbRmsDriver.setDeleted(0);
        tbRmsDriver.setCreateTime(new Date());
        tbRmsDriver.setStatus(0);


        //把司机id与物流企业id保存中间表中。
        TbRmsCustomerDriver  tbRmsCustomerDriver=new TbRmsCustomerDriver();
        tbRmsCustomerDriver.setCustomerId(rmsDriverVo.getCustomerId());
        //tbRmsCustomerDriver.setDriverId();

        return ResultUtils.successJson();
    }


    /**
     *获取客户列表
     * @return
     */
    @Override
    public JsonList listCustomerName(RmsDriverVo RmsDriverVo) {
        //查询所有物流公司名称

        JsonList jsonList = ResultUtils.successJsonList();
        return jsonList;
    }

    /**
     * 查询司机信息列表并且分页
     * @return
     */
    @Override
    public JsonList listDriverInfo(RmsDriverVo RmsDriverVo) {
        JsonList jsonList = ResultUtils.successJsonList();
        return jsonList;
    }


    /**
     * 修改司机信息
     * @return
     */
    @Override
    @Transactional
    public Json updateDriverInfo(RmsDriverVo RmsDriverVo) {

        //判断必填参数是否为空

        //根据司机id判断是否存在

        //保存到数据库中

        return ResultUtils.successJson();
    }

    /**
     * 司机停用状态
     * @return
     */
    @Override
    public Json  driverStatusQuit(String certNum){
        if(StringUtils.isEmpty(certNum)){
          ResultUtils.errorJson("100","参数为空");
        }
        TbRmsDriver tbRmsDriver=new TbRmsDriver();
        tbRmsDriver.setStatus(1);

        return ResultUtils.successJson();
    }


    /**
     * 车辆启用状态
     * @param certNum
     * @return
     */
    @Override
    public Json  driverStatusStart(String certNum){
        if(StringUtils.isEmpty(certNum)){
            ResultUtils.errorJson("100","参数为空");
        }
        TbRmsDriver tbRmsDriver=new TbRmsDriver();
        tbRmsDriver.setStatus(0);

        return ResultUtils.successJson();
    }

    /**
     * 判断身份证号是否存在
     * @param certNum
     * @return
     */
    @Override
    public Json IscertNum(String certNum) {
        TbRmsDriver tbRmsDriver = iscertNumEmpty(certNum);
        if(tbRmsDriver!=null){
            return ResultUtils.successJson("身份证已经存在");
        }
        return ResultUtils.successJson("身份证已经存在");
    }

    /**
     * 身份证号是否存在
     */
    public TbRmsDriver  iscertNumEmpty(String certNum){
        TbRmsDriver tbRmsDriver=new TbRmsDriver();
        return tbRmsDriver;
    }
}