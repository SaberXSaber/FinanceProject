package com.gsb.finance.controller;

import com.gsb.finance.pojo.FundDO;
import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;
import com.gsb.finance.service.FundService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
@RequestMapping("/fund")
public class FundController {

    @Resource
    private FundService FundServiceImpl;

    @RequestMapping("/list")
    public String list(String sharesCode,ModelMap model){
        model.addAttribute("sharesCode",sharesCode);
        return "finace/fund";
    }

    @RequestMapping(value = "/funddata")
    @ResponseBody
    public Map list(PageCondition pageCondition,String sharesCode){
        Map reslut = new HashMap();
        List<FundDO> listPages =FundServiceImpl.getList(pageCondition,sharesCode);
        int recordTotal = FundServiceImpl.getTotal(pageCondition,sharesCode);
        pageCondition.setRecordTotal(recordTotal);
        reslut.put("total", pageCondition.getTotal());
        reslut.put("rows", listPages);
        return reslut;
    }

    @RequestMapping(value="/funddetial",method = RequestMethod.GET)
    public String userorderdetial(ModelMap model,Integer fundId){
        FundDO fundDO = FundServiceImpl.getFundById(fundId);
        List<SharesDO> listShares = FundServiceImpl.getSharesByFundId(fundId);
        model.addAttribute("fundDO",fundDO);
        model.addAttribute("listShares",listShares);
        return "finace/fundDetail";
    }
}
