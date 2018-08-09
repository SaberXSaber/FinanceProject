package com.gsb.finance.startup;

import com.gsb.finance.service.SystemConfigService;
import com.gsb.finance.serviceImpl.SystemConfigServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-05-24
 * @time 16:38
 * @description
 */
@Component
public class SystemParamListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SystemConfigService systemConfigServiceImpl = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(SystemConfigServiceImpl.class);
        DictionariesHelper.getInstance(systemConfigServiceImpl).init();

        RunPushTask r1 = new RunPushTask();
        r1.task();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}