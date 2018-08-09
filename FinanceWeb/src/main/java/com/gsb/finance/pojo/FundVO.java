package com.gsb.finance.pojo;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-08
 * @time 09:48
 * @description
 */
public class FundVO extends FundDO {

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    private PageBean pageBean;
}
