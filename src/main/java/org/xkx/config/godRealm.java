package org.xkx.config;


import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.xkx.pojo.god;
import org.xkx.service.IGodService;

//自定义gadRealm

public class godRealm extends AuthorizingRealm {

    @Autowired
    IGodService iGodService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登陆时封装的token
        UsernamePasswordToken godToken= (UsernamePasswordToken) authenticationToken;
        //从数据库中查出用户名和密码
        god god = iGodService.selectGodByCount(godToken.getUsername());
        if(god==null) {
            return null;  //抛出用户名不存在异常
        }
        //可以加密 MD5  盐值加密
        Object principal=god.getCount();
        Object credentials = god.getPassword();
        ByteSource salt = ByteSource.Util.bytes(godToken.getUsername());
        String realmName = this.getName();

        //判断密码  shiro自己做
        return new SimpleAuthenticationInfo(principal,credentials,salt,realmName);
    }

}
