package com.gsb.finance.pojo;

import org.apache.commons.lang3.StringUtils;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-08
 * @time 09:45
 * @description
 */
public class PageBean {
    private Integer page;
    private Integer limit;
    private String sortDirection;
    private String sortExpression;

    public Integer getPage() {
        if(page == null || page <= 1){
            page = 1;
        }
        return (page-1)*getLimit();
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        if(limit == null || limit <= 0){
            limit = 25;
        }
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }



    public String getSortDirection() {
        if(StringUtils.isEmpty(sortDirection)){
            sortDirection = "DESC";
        }
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortExpression() {
        if(StringUtils.isEmpty(sortExpression)){
            sortExpression = "createTime";
        }
        return sortExpression;
    }

    public void setSortExpression(String sortExpression) {
        this.sortExpression = sortExpression;
    }
}
