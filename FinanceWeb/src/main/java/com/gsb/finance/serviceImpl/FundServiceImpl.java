package com.gsb.finance.serviceImpl;

import com.gsb.finance.dao.FundDao;
import com.gsb.finance.pojo.FundDO;
import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;
import com.gsb.finance.service.FundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 10:39
 * Description
 */
@Service
public class FundServiceImpl implements FundService {
    @Resource
    private FundDao fundDao;
    @Override
    public List<FundDO> getList(PageCondition pg,String sharesCode) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pg",pg);
        map.put("sharesCode",sharesCode);
        return fundDao.getList(map);
    }

    @Override
    public int getTotal(PageCondition pg,String sharesCode) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pg",pg);
        map.put("sharesCode",sharesCode);
        return fundDao.getTotal(map);
    }

    @Override
    public FundDO getFundById(Integer fundId) {
        return fundDao.getFundById(fundId);
    }

    @Override
    public List<SharesDO> getSharesByFundId(Integer fundId) {
        return fundDao.getSharesByFundId(fundId);
    }
}
