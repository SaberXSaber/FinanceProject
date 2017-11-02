package com.gsb.finance.serviceImpl;

import com.gsb.finance.dao.FundDao;
import com.gsb.finance.dao.SharesDao;
import com.gsb.finance.pojo.BuyCondition;
import com.gsb.finance.pojo.FundDO;
import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;
import com.gsb.finance.service.FundService;
import com.gsb.finance.untils.ConstantParam;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 10:39
 * Description
 */
@Service
public class FundServiceImpl implements FundService {
//    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FundServiceImpl.class);

    @Resource
    private FundDao fundDao;

    @Resource
    private SharesDao sharesDao;

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

    @Override
    public  List<Map.Entry<String,Integer>> topfund(BuyCondition pg) {
        Map sortMap = new TreeMap();
        Map<String,Object> map = new HashMap<String,Object>();
        PageCondition pag =new PageCondition();
        pag.setRecordEnd(ConstantParam.PAGE_END_NUM);
        map.put("pg",pag);
        List<FundDO> fundLists=fundDao.getList(map);
        List<String> topList = sharesDao.getTopShares(pg);
        for(FundDO f:fundLists){
            List<String> listShare = fundDao.getSharesCodeByFundId(f.getId());
            listShare.retainAll(topList);
            if(listShare.size()>ConstantParam.fund_have_topShare_NUM){
                sortMap.put(f.getFundCode()+"_"+f.getFundName(),listShare.size());
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(sortMap.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        return list;
    }
}
