package com.gsb.finance.startup;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Paul on 2017/6/13.
 */
public class StartupListener implements ServletContextListener {
    //    private static Logger logger = LoggerFactory.getLogger(StartupListener.class);
//获取spring注入的bean对象
    private WebApplicationContext springContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        logger.info("初始化业务参数....");
        try {
//            new StatManager().init();
//            WebActivityReportDao userDao= SpringFactory.getBean(WebActivityReportDao.class);
//             userDao.addActivityReport(new ArrayList<>());
//             String aaa = "11111";
//            springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
//            WebActivityReportService webActivityReportService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(WebActivityReportService.class);
//            new StatManager(webActivityReportService).init();
        } catch (Exception e) {
            e.getMessage();
        }
//        TableClosDA.init();
//        LoginDA.init();
//        logger.info("初始化完成！");
    }
    private Object getObjectFromApplication(ServletContext servletContext,String beanName){
        //通过WebApplicationContextUtils 得到Spring容器的实例。
        ApplicationContext application=WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //返回Bean的实例。
        return application.getBean(beanName);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
