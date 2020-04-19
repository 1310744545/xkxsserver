package org.xkx.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration//配置类
public class  ShiroConfig {
    //shiroFilerFactoryBean   3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        /* 在这里配置shiro内置过滤器 */
//        Map<String,String> filterMap=new LinkedHashMap<>();
//        filterMap.put("/拦截的请求","级别");
//        bean.setFilterChainDefinitionMap(filterMap);
//        bean.setLoginUrl("登陆页面");
        return bean;
    }


    //DefaultWebSecurityManager  2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getgodRealm") godRealm godRealm){
        DefaultWebSecurityManager SecurityManager = new DefaultWebSecurityManager();
        //关联Realm
        SecurityManager.setRealm(godRealm);
        return SecurityManager;
    }

    //创建Realm对象     1
    @Bean
    public godRealm getgodRealm(HashedCredentialsMatcher matcher){
        godRealm mygodRealm = new godRealm();
        mygodRealm.setCredentialsMatcher(matcher);
        return mygodRealm;
    }


    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");//散列算法
        hashedCredentialsMatcher.setHashIterations(1024);//散列的次数
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

}
