package com.gsb.finance.controller.finance;

import com.gsb.finance.pojo.RepoertVO;
import com.gsb.finance.pojo.ResultBean;
import com.gsb.finance.service.ReportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-10
 * @time 14:19
 * @description
 */
@RequestMapping("/report")
@Controller
public class ReportController {
    @Autowired
    private ReportService reportServiceImpl;

    @RequestMapping("/list")
    @ResponseBody
    public ResultBean<RepoertVO> getListByPage(@RequestBody RepoertVO repoertVO,HttpSession httpSession){
        SimpleDateFormat smdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();
        /*if(StringUtils.isBlank(repoertVO.getStartTime())){
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            repoertVO.setStartTime(smdf.format(calendar.getTime()));
        }
        if(StringUtils.isBlank(repoertVO.getEndTime())){
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            repoertVO.setEndTime(smdf.format(calendar.getTime()));
        }*/
     /*   List<RepoertVO> list = reportServiceImpl.getListByPage(repoertVO);
        int totalCount = reportServiceImpl.getTotalCount(repoertVO);*/

        try {
            repoertVO = reportServiceImpl.getReport(repoertVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBean<RepoertVO>(repoertVO, ResultBean.FAIL,"查询异常");
        }
        return new ResultBean<RepoertVO>(repoertVO);
    }

}
