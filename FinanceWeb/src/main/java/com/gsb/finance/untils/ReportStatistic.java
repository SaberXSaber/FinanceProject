package com.gsb.finance.untils;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2015/12/29
 * Time: 11:24
 * Description：客户报表
 */
public class ReportStatistic extends AbstractReportExcelView {

    @Override
    protected String getDate() {
        return super.getDate();
    }

    @Override
    protected List<String> getColumnNames(List<String> columns) {
        return columns;
    }

    @Override
    protected List<Object[]> getColumnDatas(List<Object[]> dataList) {
        return dataList;
    }


    @Override
    protected String getTitle() {
        return null;
    }

}