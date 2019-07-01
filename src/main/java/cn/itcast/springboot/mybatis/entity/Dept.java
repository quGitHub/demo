package cn.itcast.springboot.mybatis.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

public class Dept implements Serializable {
    @Id
    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;


    @Transient
    private List<User> userList;

    private static final long serialVersionUID = 1L;

    /**
     * @return dept_id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}