package com.gsb.finance.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/10/18
 * Time: 11:17
 * Description：封装返回数据
 */
@Component
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 8211828373124341287L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 200;

    public static final int FAIL = 201;

    public static final int NO_PERMISSION = 403;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(int code,String msg) {
        super();
        this.msg = msg;
        this.code = code;
    }

    public ResultBean(T data,int code,String msg) {
        super();
        this.data = data;
        this.msg = msg;
        this.code = code;
    }


    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
