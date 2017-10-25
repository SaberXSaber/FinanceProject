package com.gsb.finance.dao;

import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;
import com.gsb.finance.pojo.Youkong;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/9/12
 * Time: 18:02
 * Description：
 */
public interface PersonInfoDao {
    List<Youkong> getList_momo(PageCondition pageCondition);

    int getTotal_momo(PageCondition pageCondition);

    List<SharesDO> getList_kf(PageCondition pageCondition);

    int getTotal_kf(PageCondition pageCondition);
}
