package com.stalary.codegroup.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author:Stalary
 * @Description:管理员
 * @Date Created in 2017/8/24
 */
@Entity
@Table(name = "admin")
public class Admin extends BaseObject{

    private String name;//姓名
    private String phone;//手机号
    private String password;//密码
    private Integer position;//职位 1 会长 2 副会长 3 部门部长
    private String studentNo;//学号(账号)
    private String mail;//邮箱
    private Integer year;//年级

    public Admin() {
    }

    public Admin(Integer keyId) {
        this.keyId = keyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
