package com.gsb.finance.service;

import com.gsb.finance.pojo.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 9:30
 * Description��
 */
public interface SharesService {
    List<SharesDO> getList(PageCondition pg);
    int getTotal(PageCondition pg);

    List<SharesAnalysisVO> getsharesAnalysisList(BuyCondition pageCondition);

    int getsharesAnalysisTotal(BuyCondition pageCondition);

    List<FundDO> getFundBysharesCode(String sharesCode);
    int getFundBysharesCodeTotal(String sharesCode);

    List<SharesAnalysisVO> exportReport(BuyCondition buyCondition);

    /**
     * @return
     */
    int addSharesReport(BuyCondition pageConditio);

    List<Map.Entry<String,Integer>> diff(String time1,String time2) throws ParseException;

    List<String> getTime();
}
