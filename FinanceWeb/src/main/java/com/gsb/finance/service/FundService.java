package com.gsb.finance.service;

import com.gsb.finance.pojo.FundDO;
import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 9:30
 * Description£º
 */
public interface FundService {
    List<FundDO> getList(PageCondition pg, String sharesCode);
    int getTotal(PageCondition pg, String sharesCode);

    FundDO getFundById(Integer fundId);

    List<SharesDO> getSharesByFundId(Integer fundId);
}
