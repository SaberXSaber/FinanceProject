package com.gsb.finance.pojo;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-08
 * @time 11:03
 * @description
 */
public class SharesVO extends SharesDO {
    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    private PageBean pageBean;
}
