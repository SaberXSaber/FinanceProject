package com.gsb.finance.pojo;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 16:41
 * Description£º
 */
public class SharesAnalysisVO {
    private String sharesName;
    private String sharesCode;
    private int buyNum;
    private double totalRatio;

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

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public double getTotalRatio() {
        return totalRatio;
    }

    public void setTotalRatio(double totalRatio) {
        this.totalRatio = totalRatio;
    }
}
