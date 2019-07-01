package cn.itcast.springboot.mybatis.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_rms_driver")
public class TbRmsDriver implements Serializable {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 司机姓名
     */
    @Column(name = "driver_name")
    private String driverName;

    /**
     * 家庭地址
     */
    @Column(name = "home_address")
    private String homeAddress;

    /**
     * 性别：1-男 ；2-女；3-保密
     */
    private Integer sex;

    /**
     * 身份证号码
     */
    @Column(name = "cert_num")
    private String certNum;

    /**
     * 生日
     */
    private Date birthdate;

    /**
     * 卡户银行
     */
    @Column(name = "bank_card")
    private String bankCard;

    /**
     * 银行户名
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 银行卡号
     */
    @Column(name = "bank_num")
    private String bankNum;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 驾驶证档案号
     */
    @Column(name = "driving_file_num")
    private String drivingFileNum;

    /**
     * 数据字典：
     */
    @Column(name = "driving_license_type")
    private Integer drivingLicenseType;

    /**
     * 驾驶证发证机关
     */
    @Column(name = "issuing_unit")
    private String issuingUnit;

    /**
     * 驾驶证发证日期
     */
    @Column(name = "driving_license_time")
    private Date drivingLicenseTime;

    /**
     * 驾驶证审查日期
     */
    @Column(name = "driving_review_time")
    private Date drivingReviewTime;

    /**
     * 是否临时工：1-是；0-否
     */
    @Column(name = "is_snap")
    private Integer isSnap;

    private Integer status;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 更改人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改日期
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否删除：0-否；1是
     */
    private Integer deleted;

    /**
     * 备注信息
     */
    private String node;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取司机姓名
     *
     * @return driver_name - 司机姓名
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * 设置司机姓名
     *
     * @param driverName 司机姓名
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * 获取家庭地址
     *
     * @return home_address - 家庭地址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置家庭地址
     *
     * @param homeAddress 家庭地址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * 获取性别：1-男 ；2-女；3-保密
     *
     * @return sex - 性别：1-男 ；2-女；3-保密
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别：1-男 ；2-女；3-保密
     *
     * @param sex 性别：1-男 ；2-女；3-保密
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取身份证号码
     *
     * @return cert_num - 身份证号码
     */
    public String getCertNum() {
        return certNum;
    }

    /**
     * 设置身份证号码
     *
     * @param certNum 身份证号码
     */
    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    /**
     * 获取生日
     *
     * @return birthdate - 生日
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * 设置生日
     *
     * @param birthdate 生日
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 获取卡户银行
     *
     * @return bank_card - 卡户银行
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 设置卡户银行
     *
     * @param bankCard 卡户银行
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    /**
     * 获取银行户名
     *
     * @return bank_name - 银行户名
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行户名
     *
     * @param bankName 银行户名
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取银行卡号
     *
     * @return bank_num - 银行卡号
     */
    public String getBankNum() {
        return bankNum;
    }

    /**
     * 设置银行卡号
     *
     * @param bankNum 银行卡号
     */
    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    /**
     * 获取联系电话
     *
     * @return telephone - 联系电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置联系电话
     *
     * @param telephone 联系电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取驾驶证档案号
     *
     * @return driving_file_num - 驾驶证档案号
     */
    public String getDrivingFileNum() {
        return drivingFileNum;
    }

    /**
     * 设置驾驶证档案号
     *
     * @param drivingFileNum 驾驶证档案号
     */
    public void setDrivingFileNum(String drivingFileNum) {
        this.drivingFileNum = drivingFileNum;
    }

    /**
     * 获取数据字典：
     *
     * @return driving_license_type - 数据字典：
     */
    public Integer getDrivingLicenseType() {
        return drivingLicenseType;
    }

    /**
     * 设置数据字典：
     *
     * @param drivingLicenseType 数据字典：
     */
    public void setDrivingLicenseType(Integer drivingLicenseType) {
        this.drivingLicenseType = drivingLicenseType;
    }

    /**
     * 获取驾驶证发证机关
     *
     * @return issuing_unit - 驾驶证发证机关
     */
    public String getIssuingUnit() {
        return issuingUnit;
    }

    /**
     * 设置驾驶证发证机关
     *
     * @param issuingUnit 驾驶证发证机关
     */
    public void setIssuingUnit(String issuingUnit) {
        this.issuingUnit = issuingUnit;
    }

    /**
     * 获取驾驶证发证日期
     *
     * @return driving_license_time - 驾驶证发证日期
     */
    public Date getDrivingLicenseTime() {
        return drivingLicenseTime;
    }

    /**
     * 设置驾驶证发证日期
     *
     * @param drivingLicenseTime 驾驶证发证日期
     */
    public void setDrivingLicenseTime(Date drivingLicenseTime) {
        this.drivingLicenseTime = drivingLicenseTime;
    }

    /**
     * 获取驾驶证审查日期
     *
     * @return driving_review_time - 驾驶证审查日期
     */
    public Date getDrivingReviewTime() {
        return drivingReviewTime;
    }

    /**
     * 设置驾驶证审查日期
     *
     * @param drivingReviewTime 驾驶证审查日期
     */
    public void setDrivingReviewTime(Date drivingReviewTime) {
        this.drivingReviewTime = drivingReviewTime;
    }

    /**
     * 获取是否临时工：1-是；0-否
     *
     * @return is_snap - 是否临时工：1-是；0-否
     */
    public Integer getIsSnap() {
        return isSnap;
    }

    /**
     * 设置是否临时工：1-是；0-否
     *
     * @param isSnap 是否临时工：1-是；0-否
     */
    public void setIsSnap(Integer isSnap) {
        this.isSnap = isSnap;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取更改人
     *
     * @return update_by - 更改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更改人
     *
     * @param updateBy 更改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改日期
     *
     * @return update_time - 修改日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改日期
     *
     * @param updateTime 修改日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否删除：0-否；1是
     *
     * @return deleted - 是否删除：0-否；1是
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除：0-否；1是
     *
     * @param deleted 是否删除：0-否；1是
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取备注信息
     *
     * @return node - 备注信息
     */
    public String getNode() {
        return node;
    }

    /**
     * 设置备注信息
     *
     * @param node 备注信息
     */
    public void setNode(String node) {
        this.node = node;
    }
}