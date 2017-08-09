package com.gsb.finance.serviceImpl;

import com.gsb.finance.dao.SharesDao;
import com.gsb.finance.pojo.*;
import com.gsb.finance.service.SharesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
