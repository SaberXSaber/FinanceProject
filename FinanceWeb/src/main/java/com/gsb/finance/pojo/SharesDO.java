package com.gsb.finance.pojo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/7/31
 * Time: 16:48
 * Description
 */


public class SharesDO implements Serializable {
    private static final long serialVersionUID = 8121564170620888001L;
    private int id;
    private String sharesCode;
    private String sharesName;
    private double latestPrice;
    private double rose;
    private double netWorth;
    private double ratio;
    private int holdingShares;
    private double marketValue;
    private int fundId;
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

    public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode;
    }

    public String getSharesName() {
        return sharesName;
    }

    public void setSharesName(String sharesName) {
        this.sharesName = sharesName;
    }

    public double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public double getRose() {
        return rose;
    }

    public void setRose(double rose) {
        this.rose = rose;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getHoldingShares() {
        return holdingShares;
    }

    public void setHoldingShares(int holdingShares) {
        this.holdingShares = holdingShares;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SharesDO{" +
                "id=" + id +
                ", sharesCode='" + sharesCode + '\'' +
                ", sharesName='" + sharesName + '\'' +
                ", latestPrice=" + latestPrice +
                ", rose=" + rose +
                ", netWorth=" + netWorth +
                ", ratio=" + ratio +
                ", holdingShares=" + holdingShares +
                ", marketValue=" + marketValue +
                ", fundId=" + fundId +
                ", createTime='" + createTime + '\'' +
                '}';
    }


}
