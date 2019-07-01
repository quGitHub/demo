package cn.itcast.springboot.mybatis.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class RmsCustomerDriverVo implements Serializable {
    @Id
    private Integer id;


    private Integer customerId;

    private Integer driverId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return customer_id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @return driver_id
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * @param driverId
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

}