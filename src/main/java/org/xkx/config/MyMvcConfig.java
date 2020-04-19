package org.xkx.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//指明该类是扩展配置配置类
public class MyMvcConfig implements WebMvcConfigurer {
    @Override   //该方法配置请求的指向
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("index").setViewName("index");
        registry.addViewController("loginpage").setViewName("login");
        registry.addViewController("zhucepage").setViewName("zhuce");
        registry.addViewController("managerloginpage").setViewName("managerlogin");
        registry.addViewController("testpage").setViewName("test.html");
        registry.addViewController("godsinformation").setViewName("godsinformation.html");
    }

    @Override   //该方法配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/houtai/**");

    }
}
