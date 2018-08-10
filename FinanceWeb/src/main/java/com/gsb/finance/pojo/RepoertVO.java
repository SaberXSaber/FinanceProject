package com.gsb.finance.pojo;

import java.util.List;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-10
 * @time 14:22
 * @description
 */
public class RepoertVO {
    private List<String> titleList;
    private List<String> dateList;
    private List<BarView> DataList;


    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }


    public List<String> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    public List<BarView> getDataList() {
        return DataList;
    }

    public void setDataList(List<BarView> dataList) {
        DataList = dataList;
    }
}
