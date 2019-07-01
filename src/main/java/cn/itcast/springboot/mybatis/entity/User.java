package cn.itcast.springboot.mybatis.entity;

import java.io.Serializable;
import javax.persistence.*;

public class User implements Serializable {
    /**
     * 主键id
     */
    @Id
    @Column(name = "t_id")
    private Integer tId;

    /**
     * 手机号
     */
    @Column(name = "t_tel")
    private String tTel;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    private String pasword;

    /**
     * 年龄
     */
    @Column(name = "t_age")
    private Byte tAge;

    /**
     * 部门id
     */
    @Column(name = "t_dept_id")
    private Integer tDeptId;


    @Transient
    private Dept dept;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return t_id - 主键id
     */
    public Integer gettId() {
        return tId;
    }

    /**
     * 设置主键id
     *
     * @param tId 主键id
     */
    public void settId(Integer tId) {
        this.tId = tId;
    }

    /**
     * 获取手机号
     *
     * @return t_tel - 手机号
     */
    public String gettTel() {
        return tTel;
    }

    /**
     * 设置手机号
     *
     * @param tTel 手机号
     */
    public void settTel(String tTel) {
        this.tTel = tTel;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户密码
     *
     * @return pasword - 用户密码
     */
    public String getPasword() {
        return pasword;
    }

    /**
     * 设置用户密码
     *
     * @param pasword 用户密码
     */
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    /**
     * 获取年龄
     *
     * @return t_age - 年龄
     */
    public Byte gettAge() {
        return tAge;
    }

    /**
     * 设置年龄
     *
     * @param tAge 年龄
     */
    public void settAge(Byte tAge) {
        this.tAge = tAge;
    }

    /**
     * 获取部门id
     *
     * @return t_dept_id - 部门id
     */
    public Integer gettDeptId() {
        return tDeptId;
    }

    /**
     * 设置部门id
     *
     * @param tDeptId 部门id
     */
    public void settDeptId(Integer tDeptId) {
        this.tDeptId = tDeptId;
    }


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}