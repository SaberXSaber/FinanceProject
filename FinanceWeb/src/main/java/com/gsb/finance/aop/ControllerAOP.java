package com.gsb.finance.aop;

import com.gsb.finance.exception.CheckException;
import com.gsb.finance.pojo.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/10/18
 * Time: 11:32
 * Description：处理接口调用发生的异常
 */
public class ControllerAOP {
    private final static Logger logger  = LoggerFactory.getLogger(ControllerAOP.class);

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;

        try {
            result = (ResultBean<?>) pjp.proceed();
            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();

        // 已知异常
        if (e instanceof CheckException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        }/* else if (e instanceof UnloginException) {
            result.setMsg("Unlogin");
            result.setCode(ResultBean.NO_LOGIN);
        } */else {
            logger.error(pjp.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);
        }

        return result;
    }
}
