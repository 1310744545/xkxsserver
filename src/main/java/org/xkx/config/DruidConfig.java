package org.xkx.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration //配置类
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")//绑定数据源的配置文件
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        HashMap<String, String> iniParameters = new HashMap<>();

        //增加配置
        iniParameters.put("loginUsername","sa");
        iniParameters.put("loginPassword","asd");

        //允许谁访问
        iniParameters.put("allow","");

        //禁止谁访问iniParameters.put("xxx","192.168.1.1");

        bean.setInitParameters(iniParameters);
        return bean;
    }

    //Filter
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean bean=new FilterRegistrationBean();
//        bean.setFilter(new WebStatFilter());
//        Map<String,String> initParameters=new HashMap<>();
//
//        initParameters.put("exclusions","*.js,*.css,durid/*");//不拦截的东西
//
//        bean.setInitParameters(initParameters);
//        return bean;
//    }

}
