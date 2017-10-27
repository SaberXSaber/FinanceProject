package com.gsb.finance.serviceImpl;

import com.gsb.finance.dao.SharesDao;
import com.gsb.finance.pojo.*;
import com.gsb.finance.service.SharesService;
import com.gsb.finance.untils.FuncUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 10:38
 * Description��
 */
@Service
public class SharesServiceImpl implements SharesService {
    @Resource
    private SharesDao sharesDao;
    @Override
    public List<SharesDO> getList(PageCondition pg) {
        return sharesDao.getList(pg);
    }

    @Override
    public int getTotal(PageCondition pg) {
        return sharesDao.getTotal(pg);
    }

    @Override
    public List<SharesAnalysisVO> getsharesAnalysisList(BuyCondition pageCondition) {
        return sharesDao.getsharesAnalysisList(pageCondition);
    }

    @Override
    public int getsharesAnalysisTotal(BuyCondition pageCondition) {
        return sharesDao.getsharesAnalysisTotal(pageCondition);
    }

    @Override
    public List<FundDO> getFundBysharesCode(String sharesCode) {
        return sharesDao.getFundBysharesCode(sharesCode);
    }

    @Override
    public int getFundBysharesCodeTotal(String sharesCode) {
        return sharesDao.getFundBysharesCodeTotal(sharesCode);
    }

    @Override
    public List<SharesAnalysisVO> exportReport(BuyCondition buyCondition) {
        return sharesDao.exportReport(buyCondition);
    }

    @Override
    public int addSharesReport(BuyCondition pageCondition) {
        List<SharesAnalysisVO> list = getsharesAnalysisList(pageCondition);
        return sharesDao.addsharesreportBatch(list);
    }

    @Override
    public  List<Map.Entry<String,Integer>> diff(String time1,String time2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<SharesReport> list = sharesDao.recordByTime(time1);
        List<SharesReport> list2 = sharesDao.recordByTime(time2);
        String flag=sdf.parse(time1).getTime()<sdf.parse(time2).getTime()?"(新增)":"(去除)";
        return FuncUtils.diffList(list, list2,flag);
    }

    @Override
    public List<String> getTime() {
        return  sharesDao.getTime();
    }
}
