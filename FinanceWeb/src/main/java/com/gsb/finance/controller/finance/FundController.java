package com.gsb.finance.controller.finance;

import com.gsb.finance.pojo.BuyCondition;
import com.gsb.finance.pojo.FundDO;
import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;
import com.gsb.finance.service.FundService;
import com.gsb.finance.untils.ConstantParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
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
@RequestMapping("/fund")
public class FundController {

    @Resource
    private FundService fundServiceImpl;

    @RequestMapping("/list")
    public String list(String sharesCode,ModelMap model){
        model.addAttribute("sharesCode",sharesCode);
        return "finace/fund";
    }

    @RequestMapping(value = "/funddata")
    @ResponseBody
    public Map list(PageCondition pageCondition,String sharesCode){
        Map reslut = new HashMap();
        List<FundDO> listPages =fundServiceImpl.getList(pageCondition,sharesCode);
        int recordTotal = fundServiceImpl.getTotal(pageCondition,sharesCode);
        pageCondition.setRecordTotal(recordTotal);
        reslut.put("total", pageCondition.getTotal());
        reslut.put("rows", listPages);
        return reslut;
    }

    @RequestMapping(value="/funddetial",method = RequestMethod.GET)
    public String userorderdetial(ModelMap model,Integer fundId){
        FundDO fundDO = fundServiceImpl.getFundById(fundId);
        List<SharesDO> listShares = fundServiceImpl.getSharesByFundId(fundId);
        model.addAttribute("fundDO",fundDO);
        model.addAttribute("listShares",listShares);
        return "finace/fundDetail";
    }

    @RequestMapping("/fundresult")
    public String result(Integer start,Integer endnum ,ModelMap model)  {
        BuyCondition pageCondition = new BuyCondition();
        if(null != endnum){
            pageCondition.setRecordEnd(endnum);
        }else {
            pageCondition.setRecordEnd(ConstantParam.PAGE_END_NUM);
        }
        List<Map.Entry<String,Integer>> map = fundServiceImpl.topfund(pageCondition);
//        List<Map.Entry<String, Integer>> listdiff  = new ArrayList<Map.Entry<String, Integer>>((Collection<? extends Map.Entry<String, Integer>>) map);
        model.addAttribute("listdiff",map);
        return "finace/fundresult";
    }
}
