package com.gsb.finance.dao;

import com.gsb.finance.pojo.*;

import java.util.List;
import java.util.Map;

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

    int addsharesreportBatch(List<SharesAnalysisVO> list);

    List<SharesReport> recordByTime(String str);

    List<String> getTime();

    List<String> getTopShares(BuyCondition pageCondition);

    int updateTest(int value);
}
