package com.gsb.finance.serviceImpl;

import com.gsb.finance.dao.ReportDao;
import com.gsb.finance.pojo.BarView;
import com.gsb.finance.pojo.RepoertVO;
import com.gsb.finance.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-10
 * @time 14:31
 * @description
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public RepoertVO getReport(RepoertVO repoertVO) {
        if(null!=repoertVO&&null!=repoertVO.getTitleList()&&repoertVO.getTitleList().size()>0){
            List<String>dateList= reportDao.getDateList(repoertVO);
            List<BarView>  listbar = new ArrayList<BarView>();
            repoertVO.setDateList(dateList);
            for (String sharescode:repoertVO.getTitleList()){
                BarView<Integer> barView =new BarView<Integer>();
                barView.setName(sharescode);
                barView.setData(reportDao.getDataList(sharescode));
                listbar.add(barView);
            }
            repoertVO.setDataList(listbar);
        }
        return repoertVO;
    }
}
