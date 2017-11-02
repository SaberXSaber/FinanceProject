package com.gsb.finance.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/3/6
 * Time: 17:07
 * Description：
 */
public class BuyCondition extends PageCondition{
    private Double oneMonth =0.0;
    private Double threeMonth=0.0;
    private Double sixMonth=5.0;
    private Double oneYear=10.0;
    private Double threeYear=15.0;
    private Double always = 20.0;

    public Double getThreeYear() {
        return threeYear;
    }

    public void setThreeYear(Double threeYear) {
        this.threeYear = threeYear;
    }

    public Double getOneMonth() {
        return oneMonth;
    }

    public void setOneMonth(Double oneMonth) {
        this.oneMonth = oneMonth;
    }

    public Double getThreeMonth() {
        return threeMonth;
    }

    public void setThreeMonth(Double threeMonth) {
        this.threeMonth = threeMonth;
    }

    public Double getSixMonth() {
        return sixMonth;
    }

    public void setSixMonth(Double sixMonth) {
        this.sixMonth = sixMonth;
    }

    public Double getOneYear() {
        return oneYear;
    }

    public void setOneYear(Double oneYear) {
        this.oneYear = oneYear;
    }

    public Double getAlways() {
        return always;
    }

    public void setAlways(Double always) {
        this.always = always;
    }
}
