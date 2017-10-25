package com.gsb.finance.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2016/12/22
 * Time: 14:47
 * Description：
 */
@Entity
@Table(name="person")
public class PersonBean implements Serializable {
    private static final long serialVersionUID = 4164901194774292852L;
    private int id;
    private String name;
    private int age;
    private String card;
    private String sex;
    private String address;
    private String phone;
    private String email;
    private String loginName;
    private String password;
    private String password2;
    private String birth;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "id=" + id +
                ",name=" + name +
                ", age=" + age +
                ", birth=" + birth +
                ", card=" + card +
                ", sex=" + sex +
                ", address=" + address +
                ", phone=" + phone +
                ", email=" + email +
                ", loginName=" + loginName +
                ", password=" + password +
                ", password2=" + password2 +
                ", location=" + location +
                '}';
    }
}
