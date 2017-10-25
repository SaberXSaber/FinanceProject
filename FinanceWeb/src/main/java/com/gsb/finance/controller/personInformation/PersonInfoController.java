package com.gsb.finance.controller.personInformation;

import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.pojo.SharesDO;
import com.gsb.finance.pojo.Youkong;
import com.gsb.finance.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/9/11
 * Time: 18:20
 * Description：
 */

@Controller
@RequestMapping("/personInfo")
public class PersonInfoController {

    @Autowired
    private PersonInfoService personInfoServiceImpl;

    @RequestMapping()
    public String search(String str){
        return null;

    }

    @RequestMapping("/kf")
    @ResponseBody
    public Map kaifang(PageCondition pageCondition){
        Map reslut = new HashMap();
        List<SharesDO> listPages =personInfoServiceImpl.getList_kf(pageCondition);
        int recordTotal = personInfoServiceImpl.getTotal_kf(pageCondition);
        pageCondition.setRecordTotal(recordTotal);
        reslut.put("total", pageCondition.getTotal());
        reslut.put("rows", listPages);
        return reslut;

    }

    @RequestMapping("/momo")
    @ResponseBody
    public Map momo(PageCondition pageCondition){
        Map reslut = new HashMap();
        List<Youkong> listPages =personInfoServiceImpl.getList_momo(pageCondition);
        int recordTotal = personInfoServiceImpl.getTotal_momo(pageCondition);
        pageCondition.setRecordTotal(recordTotal);
        reslut.put("total", pageCondition.getTotal());
        reslut.put("rows", listPages);
        return reslut;
    }
}
