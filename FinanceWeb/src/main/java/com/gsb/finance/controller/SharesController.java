package com.gsb.finance.controller;

import com.gsb.finance.pojo.*;
import com.gsb.finance.service.SharesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/1
 * Time: 9:29
 * Description£º
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
}
