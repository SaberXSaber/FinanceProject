package com.gsb.finance.serviceImpl;

import com.gsb.finance.dao.PersonInfoDao;
import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;
import com.gsb.finance.pojo.Youkong;
import com.gsb.finance.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/9/12
 * Time: 18:01
 * Description：
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoDao personInfoDao;

    @Override
    public List<Youkong> getList_momo(PageCondition pageCondition) {
        return personInfoDao.getList_momo(pageCondition);
    }

    @Override
    public int getTotal_momo(PageCondition pageCondition) {
        return personInfoDao.getTotal_momo(pageCondition);
    }

    @Override
    public List<SharesDO> getList_kf(PageCondition pageCondition) {
        return personInfoDao.getList_kf(pageCondition);
    }

    @Override
    public int getTotal_kf(PageCondition pageCondition) {
        return personInfoDao.getTotal_kf(pageCondition);
    }
}
