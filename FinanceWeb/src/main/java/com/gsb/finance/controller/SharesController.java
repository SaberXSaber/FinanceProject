package com.gsb.finance.controller;

import com.alibaba.fastjson.JSONObject;
import com.gsb.finance.pojo.*;
import com.gsb.finance.service.SharesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 9:29
 * Description��
 */

@Controller
@RequestMapping("/shares")
public class SharesController {

    @Resource
    private SharesService sharesServiceImpl;

    @RequestMapping("/list")
    public String list(){
        return "finace/shares";
    }

    @RequestMapping(value = "/sharesdata")
    @ResponseBody
    public Map list(PageCondition pageCondition){
        Map reslut = new HashMap();
        List<SharesDO> listPages =sharesServiceImpl.getList(pageCondition);
        int recordTotal = sharesServiceImpl.getTotal(pageCondition);
        pageCondition.setRecordTotal(recordTotal);
        reslut.put("total", pageCondition.getTotal());
        reslut.put("rows", listPages);
        return reslut;
    }

    @RequestMapping("/sharesAnalysis")
    public String sharesAnalysis(){
        return "finace/buy";
    }

    @RequestMapping(value = "/sharesAnalysisdata")
    @ResponseBody
    public Map sharesAnalysisdata(BuyCondition buyCondition,HttpServletRequest request){
        Map reslut = new HashMap();
        List<SharesAnalysisVO> listPages =sharesServiceImpl.getsharesAnalysisList(buyCondition);
        int recordTotal = sharesServiceImpl.getsharesAnalysisTotal(buyCondition);
        buyCondition.setRecordTotal(recordTotal);
        reslut.put("total", buyCondition.getTotal());
        reslut.put("rows", listPages);
        return reslut;
    }

    @RequestMapping(value="/getFundBysharesCode",method = RequestMethod.GET)
    @ResponseBody
    public String getFundBysharesCode(ModelMap model,String sharesCode){
        Map reslut = new HashMap();
        List<FundDO> listPages =sharesServiceImpl.getFundBysharesCode(sharesCode);
        int recordTotal = sharesServiceImpl.getFundBysharesCodeTotal(sharesCode);
       /* pageCondition.setRecordTotal(recordTotal);
        reslut.put("total", pageCondition.getTotal());
        reslut.put("rows", listPages);
        return reslut;*/
        model.addAttribute("recordTotal",recordTotal);
        model.addAttribute("listPages",listPages);
        return "finace/fundDetail";
    }


    @RequestMapping("/exportReport")
    public ModelAndView exportReport(BuyCondition buyCondition,Model model) {

        List<SharesAnalysisVO> exportReportList=sharesServiceImpl.exportReport(buyCondition);

        List<String> columns = new ArrayList<String>();
        columns.add("股票代码");
        columns.add("股票名称");
        columns.add("购买基金数");
        columns.add("涨跌幅总和");
        model.addAttribute("columns", columns);
        List<Object[]> dataList = new ArrayList<Object[]>();
        if (exportReportList != null && exportReportList.size() > 0) {
            for (int i = 0; i < exportReportList.size(); i++) {
                SharesAnalysisVO reportStatistic = exportReportList.get(i);
                List<Object> list = new ArrayList<Object>();
                list.add(reportStatistic.getSharesCode());
                list.add(reportStatistic.getSharesName());
                list.add(reportStatistic.getBuyNum());
                list.add(reportStatistic.getTotalRatio());
                dataList.add(list.toArray());
            }
        }
        StringBuilder fileName =new StringBuilder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        fileName.append("分析表");
        fileName.append(sdf.format(new Date()));
        model.addAttribute("fileName", fileName);
        model.addAttribute("columnDatas", dataList);
        return new ModelAndView("ReportStatistic", "exportReportList", exportReportList);
    }

}
