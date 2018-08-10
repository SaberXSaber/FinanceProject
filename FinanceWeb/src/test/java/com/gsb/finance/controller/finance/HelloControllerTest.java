package com.gsb.finance.controller.finance;

import com.gsb.finance.pojo.UserBean;
import com.gsb.finance.service.PersonInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/11/14
 * Time: 11:40
 * Description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class HelloControllerTest {
    @Autowired
    private PersonInfoService personInfoServiceImpl;

    @Test
    public void testTest1() throws Exception {
        UserBean useBean = new UserBean();
        useBean.setEmail("abc3@qq.com");
        useBean.setNick_name("nabc3");
        useBean.setPass_word("abcp3");
        useBean.setUser_name("abc3");
        personInfoServiceImpl.addTest(useBean);
    }
}