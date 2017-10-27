package com.gsb.finance.pojo;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/10/27
 * Time: 15:14
 * Description：
 */
public class SharesReport {
    private Integer id;
    private Integer sharesId;
    private String sharesCode;
    private String sharesName;
    private Integer fundOwnedcount;
    private String recordtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSharesId() {
        return sharesId;
    }

    public void setSharesId(Integer sharesId) {
        this.sharesId = sharesId;
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

    public Integer getFundOwnedcount() {
        return fundOwnedcount;
    }

    public void setFundOwnedcount(Integer fundOwnedcount) {
        this.fundOwnedcount = fundOwnedcount;
    }

    public String getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(String recordtime) {
        this.recordtime = recordtime;
    }

    @Override
    public String toString() {
        return "SharesReport{" +
                "id=" + id +
                ", sharesId=" + sharesId +
                ", sharesCode='" + sharesCode + '\'' +
                ", sharesName='" + sharesName + '\'' +
                ", fundOwnedcount=" + fundOwnedcount +
                ", recordtime='" + recordtime + '\'' +
                '}';
    }
}
