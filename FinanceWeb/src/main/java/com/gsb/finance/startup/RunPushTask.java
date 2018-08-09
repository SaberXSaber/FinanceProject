package com.gsb.finance.startup;


import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
import java.util.Random;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-06-15
 * @time 11:11
 * @description
 */
@Component
public class RunPushTask {
    WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//    UserService webUserServiceImpl = (UserService) wac.getBean("webUserServiceImpl");

    /**
     *
     */
    public void task( ){
        System.out.println("task is runing");
       /* Thread t =new  Thread(new Runnable() {
            @Override
            public void run() {
                while (false){
                    System.out.println("task is runing");
                }
            }
        });
        t.start();*/
    }
}
