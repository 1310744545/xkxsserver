package org.xkx.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {//继承拦截器接口

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object asd = request.getSession().getAttribute("asd");//尝试获取session中的manager
        if(asd==null){
            request.setAttribute("msg", "没有权限，请登陆");   //在request域中加入消息
            request.getRequestDispatcher("managerloginpage").forward(request,response); //请求转发
            return false; //不放行
        }else {
            return true;
        }
    }
}
