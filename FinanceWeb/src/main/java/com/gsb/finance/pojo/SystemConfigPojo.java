package com.gsb.finance.pojo;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-05-24
 * @time 10:34
 * @description
 */
public class SystemConfigPojo {

    private Integer id;
    private String paramName;
    private String paramValue;
    private String remark;
    private Integer curState;
    private String createTime;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCurState() {
        return curState;
    }

    public void setCurState(Integer curState) {
        this.curState = curState;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SystemConfigPojo{" +
                "id=" + id +
                ", paramName='" + paramName + '\'' +
                ", paramValue='" + paramValue + '\'' +
                ", remark='" + remark + '\'' +
                ", curState=" + curState +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
