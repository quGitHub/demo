package cn.itcast.springboot.mybatis.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_rms_customer_driver")
public class TbRmsCustomerDriver implements Serializable {
    @Id
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "driver_id")
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