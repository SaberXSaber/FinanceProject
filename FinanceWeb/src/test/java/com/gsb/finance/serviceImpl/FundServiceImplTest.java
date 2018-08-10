package com.gsb.finance.serviceImpl;

import com.gsb.finance.pojo.PageCondition;
import com.gsb.finance.service.FundService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/11/1
 * Time: 18:00
 * Description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class FundServiceImplTest {

    @Autowired
    private FundService fundServiceImpl;

    @Test
    public void testTopfund() throws Exception {
        PageCondition pg = new PageCondition();

       /* List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Entry<String, String> o1,
                               Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });*/

       /* Map<String, Integer> map = fundServiceImpl.topfund(pg);

        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }*/

    }



}