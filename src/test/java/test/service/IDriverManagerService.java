package test.service;

import cn.itcast.springboot.mybatis.entity.RmsDriverVo;
import cn.itcast.springboot.mybatis.vo.base.Json;
import cn.itcast.springboot.mybatis.vo.base.JsonList;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/7 9:35
 * @Description:
 */
public interface IDriverManagerService {

    public Json addDriver(RmsDriverVo rmsDriverVo);

    public JsonList listCustomerName( RmsDriverVo rmsDriverVo);

    public JsonList  listDriverInfo(RmsDriverVo rmsDriverVo );

    public Json updateDriverInfo(RmsDriverVo rmsDriverVo );

    public Json  driverStatusQuit(String certNum);

    public Json  driverStatusStart(String certNum);

    public Json IscertNum(String certNum);
}
