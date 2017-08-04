package com.gsb.finance.pojo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/7/31
 * Time: 16:47
 * Description£º»ù½ð
 */


public class FundDO implements Serializable{
    private static final long serialVersionUID = -77546835820484387L;
    private int id;
    private String fundCode;
    private String fundName;
    private String detailedUrl;
    private double dailyValue;
    private double dailyRate;
    private double estimateValue;
    private double unitValue;
    private double cumulativeValue;
    private double oneMonth;
    private double threeMonth;
    private double sixMonth;
    private double oneYear;
    private double threeYear;
    private double always;
    private double fundScale;
    private String fundManager;
    private String manager;
    private String fundRating;
    private String poundage;
    private String applyState;
    private String redeemState;
    private String bulidDate;
    private String createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getDetailedUrl() {
        return detailedUrl;
    }

    public void setDetailedUrl(String detailedUrl) {
        this.detailedUrl = detailedUrl;
    }

    public double getDailyValue() {
        return dailyValue;
    }

    public void setDailyValue(double dailyValue) {
        this.dailyValue = dailyValue;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getEstimateValue() {
        return estimateValue;
    }

    public void setEstimateValue(double estimateValue) {
        this.estimateValue = estimateValue;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public double getCumulativeValue() {
        return cumulativeValue;
    }

    public void setCumulativeValue(double cumulativeValue) {
        this.cumulativeValue = cumulativeValue;
    }

    public double getOneMonth() {
        return oneMonth;
    }

    public void setOneMonth(double oneMonth) {
        this.oneMonth = oneMonth;
    }

    public double getThreeMonth() {
        return threeMonth;
    }

    public void setThreeMonth(double threeMonth) {
        this.threeMonth = threeMonth;
    }

    public double getSixMonth() {
        return sixMonth;
    }

    public void setSixMonth(double sixMonth) {
        this.sixMonth = sixMonth;
    }

    public double getOneYear() {
        return oneYear;
    }

    public void setOneYear(double oneYear) {
        this.oneYear = oneYear;
    }

    public double getThreeYear() {
        return threeYear;
    }

    public void setThreeYear(double threeYear) {
        this.threeYear = threeYear;
    }

    public double getAlways() {
        return always;
    }

    public void setAlways(double always) {
        this.always = always;
    }

    public double getFundScale() {
        return fundScale;
    }

    public void setFundScale(double fundScale) {
        this.fundScale = fundScale;
    }

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getFundRating() {
        return fundRating;
    }

    public void setFundRating(String fundRating) {
        this.fundRating = fundRating;
    }

    public String getPoundage() {
        return poundage;
    }

    public void setPoundage(String poundage) {
        this.poundage = poundage;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public String getRedeemState() {
        return redeemState;
    }

    public void setRedeemState(String redeemState) {
        this.redeemState = redeemState;
    }

    public String getBulidDate() {
        return bulidDate;
    }

    public void setBulidDate(String bulidDate) {
        this.bulidDate = bulidDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FundDO{" +
                "id=" + id +
                ", fundCode='" + fundCode + '\'' +
                ", fundName='" + fundName + '\'' +
                ", detailedUrl='" + detailedUrl + '\'' +
                ", dailyValue=" + dailyValue +
                ", dailyRate=" + dailyRate +
                ", estimateValue=" + estimateValue +
                ", unitValue=" + unitValue +
                ", cumulativeValue=" + cumulativeValue +
                ", oneMonth=" + oneMonth +
                ", threeMonth=" + threeMonth +
                ", sixMonth=" + sixMonth +
                ", oneYear=" + oneYear +
                ", threeYear=" + threeYear +
                ", always=" + always +
                ", fundScale=" + fundScale +
                ", fundManager='" + fundManager + '\'' +
                ", manager='" + manager + '\'' +
                ", fundRating='" + fundRating + '\'' +
                ", poundage='" + poundage + '\'' +
                ", applyState='" + applyState + '\'' +
                ", redeemState='" + redeemState + '\'' +
                ", bulidDate='" + bulidDate + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
