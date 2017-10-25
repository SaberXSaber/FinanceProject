package com.gsb.finance.pojo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/9/11
 * Time: 18:10
 * Description：
 */
public class Youkong implements Serializable{
    private static final long serialVersionUID = -2999629634940965824L;
    private  int user_id;
    private  String user_nick;
    private  String user_sex;
    private  String user_location;
    private  String user_brithday;
    private  String user_zodiac;
    private  String user_weixin;
    private  String user_momo;
    private  String user_qq;
    private  int user_age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public String getUser_brithday() {
        return user_brithday;
    }

    public void setUser_brithday(String user_brithday) {
        this.user_brithday = user_brithday;
    }

    public String getUser_zodiac() {
        return user_zodiac;
    }

    public void setUser_zodiac(String user_zodiac) {
        this.user_zodiac = user_zodiac;
    }

    public String getUser_weixin() {
        return user_weixin;
    }

    public void setUser_weixin(String user_weixin) {
        this.user_weixin = user_weixin;
    }

    public String getUser_momo() {
        return user_momo;
    }

    public void setUser_momo(String user_momo) {
        this.user_momo = user_momo;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    @Override
    public String toString() {
        return "Youkong{" +
                "user_id=" + user_id +
                ", user_nick='" + user_nick + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_location='" + user_location + '\'' +
                ", user_brithday='" + user_brithday + '\'' +
                ", user_zodiac='" + user_zodiac + '\'' +
                ", user_weixin='" + user_weixin + '\'' +
                ", user_momo='" + user_momo + '\'' +
                ", user_qq='" + user_qq + '\'' +
                ", user_age=" + user_age +
                '}';
    }
}
