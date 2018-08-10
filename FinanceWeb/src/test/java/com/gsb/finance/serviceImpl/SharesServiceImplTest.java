package com.gsb.finance.serviceImpl;


import com.gsb.finance.pojo.BuyCondition;
import com.gsb.finance.service.SharesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/29
 * Time: 10:47
 * Description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class SharesServiceImplTest {

    @Autowired
    private SharesService sharesService;


    @Test
    public void testGetFundBysharesCodeTotal() throws Exception {
        System.out.println( sharesService.getFundBysharesCodeTotal("600201"));

    }


    @Test
    public void testaddSharesReport() throws Exception {
        BuyCondition pageCondition = new BuyCondition();
      /*  pageCondition.setOneMonth(0.00);
        pageCondition.setThreeMonth(5.00);
        pageCondition.setSixMonth(10.00);*/
      /*  pageCondition.setOneYear(15.00);
        pageCondition.setThreeYear(20.00);
        pageCondition.setAlways(25.00);*/
        pageCondition.setRecordStart(0);
        pageCondition.setRecordEnd(100);
        System.out.println( sharesService.addSharesReport(pageCondition));
    }

    @Test
    public void  testdiff() throws ParseException {
        List<Map.Entry<String,Integer>> list = sharesService.diff("2017-10-25", "2017-10-27");
        for(Map.Entry<String,Integer> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}