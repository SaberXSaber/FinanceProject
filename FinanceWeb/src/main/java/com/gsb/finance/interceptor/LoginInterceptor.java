package com.gsb.finance.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


class LoginInterceptor implements HandlerInterceptor {

    private static final String[] letGoUrls = {"/loginmethod","/login", "/error", "index", "/checkcode/code"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //region 登陆验证
        boolean resultFinal = false;
        //获取请求的URL
        String url = request.getRequestURI();
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        for(String s : letGoUrls){
            if(url.contains(s)){//url包含登录相关的链接
                resultFinal =  true;
                break; //跳出
            }
        }
        if(!resultFinal) {
            //获取Session
            HttpSession session = request.getSession();
          /*  OperatorEntity operator = (OperatorEntity)session.getAttribute(ParamUtils.SEESION_OPERATOR);
            if (operator != null) {
                try {
                    if (operator.getOperatorId() != 1) {
                    }
                } catch (Exception e) {
                    String msg = e.getMessage();
                }
                resultFinal =  true;
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", "401");
                jsonObject.put("msg", "登陆过期,请重新登录");

                response.setCharacterEncoding("utf-8");
                response.addHeader("Content-Type", "application/json");
                response.getWriter().print(jsonObject.toString());
            }
*/
        }

        return resultFinal;
        //endregion
//        return  true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
