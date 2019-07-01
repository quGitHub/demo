package cn.hacz.edu.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/9/21 10:05
 * @Description:
 */
public class Admin {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String phone;

    private LocalDate createDate;

   private LocalDateTime updateDate;

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
