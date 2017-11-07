package com.gsb.finance.service;

import com.gsb.finance.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 9:30
 * Description
 */
public interface FundService {
    List<FundDO> getList(FundCondition pg);
    int getTotal(FundCondition pg);

    FundDO getFundById(Integer fundId);

    List<SharesDO> getSharesByFundId(Integer fundId);

    List<Map.Entry<String,Integer>> topfund(BuyCondition pg);

}
