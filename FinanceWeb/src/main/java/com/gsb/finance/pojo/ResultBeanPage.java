package com.gsb.finance.pojo;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/10/18
 * Time: 11:19
 * Description：带分页封装返回数据
 */
@Component
public class ResultBeanPage<T> extends ResultBean {
    private static final long serialVersionUID = 747294204217024650L;


    private Integer totalCount;

    public ResultBeanPage() {
        super();
    }


    public ResultBeanPage(Integer totalCount) {
        super();
        this.totalCount = totalCount;
    }


    public ResultBeanPage(Object data, Integer totalCount) {
        super(data);
        this.totalCount = totalCount;
    }

    public ResultBeanPage(Object data, int code, String msg, Integer totalCount) {
        super(data, code, msg);
        this.totalCount = totalCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
