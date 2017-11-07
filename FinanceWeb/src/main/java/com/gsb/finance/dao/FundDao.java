package com.gsb.finance.dao;

import com.gsb.finance.pojo.FundCondition;
import com.gsb.finance.pojo.FundDO;
import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 9:30
 * Description
 */
public interface FundDao {
    List<FundDO> getList(FundCondition pg);
    int getTotal(FundCondition pg);
    FundDO getFundById(Integer fundId);

    List<SharesDO> getSharesByFundId(Integer fundId);

    List<String> getSharesCodeByFundId(int id);
}
