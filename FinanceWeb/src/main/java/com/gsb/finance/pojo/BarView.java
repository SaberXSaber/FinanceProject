package com.gsb.finance.pojo;

import java.util.List;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-10
 * @time 15:34
 * @description
 */
public class BarView<T> {
    private String name;
    private String type="line";
    private String stack="总量";
    private List<T> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
