package com.gsb.finance.dao;

import com.gsb.finance.pojo.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 9:30
 * Description��
 */
public interface SharesDao {
    List<SharesDO> getList(PageCondition pg);
    int getTotal(PageCondition pg);

    List<SharesAnalysisVO> getsharesAnalysisList(BuyCondition pageCondition);

    int getsharesAnalysisTotal(BuyCondition pageCondition);

    List<FundDO> getFundBysharesCode(String sharesCode);
    int getFundBysharesCodeTotal(String sharesCode);
    List<SharesAnalysisVO> exportReport(BuyCondition buyCondition);

}
