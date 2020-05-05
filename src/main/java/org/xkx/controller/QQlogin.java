package org.xkx.controller;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: QQ登录控制器
 * @author: xw
 * @date 2020/2/21 10:54
 * @Version: 1.0
 **/
@Controller
public class QQlogin {
    /**
     * @Description 请求QQ登录
     * @Author xw
     * @Date 11:25 2020/2/21
     * @Param [request, response]
     * @return void
     **/
    @RequestMapping("/loginByQQ")
    public void loginByQQ(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
            System.out.println("请求QQ登录,开始跳转...");
        } catch (QQConnectException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description QQ登录的回调方法
     * @Author xw
     * @Date 11:25 2020/2/21
     * @Param [request, response, map]
     * @return java.lang.String
     **/
    @RequestMapping("/connection")
    public String connection(HttpServletRequest request, HttpServletResponse response, Map<String,Object> map) {
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            String accessToken = null, openID = null;
            long tokenExpireIn = 0L;
            if ("".equals(accessTokenObj.getAccessToken())) {
                System.out.println("登录失败:没有获取到响应参数");
                return "accessTokenObj=>" + accessTokenObj + "; accessToken" + accessTokenObj.getAccessToken();
            } else {
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();
                System.out.println("accessToken" + accessToken);
                request.getSession().setAttribute("demo_access_token", accessToken);
                request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));

                // 利用获取到的accessToken 去获取当前用的openid -------- start
                OpenID openIDObj = new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();

                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                    String name = removeNonBmpUnicode(userInfoBean.getNickname());
                    String imgUrl = userInfoBean.getAvatar().getAvatarURL100();
                    map.put("openId",openID);
                    map.put("name",name);
                    map.put("imgUrl",imgUrl);
                } else {
                    System.out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
                }
            }
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        return "index/index";
    }

    /**
     * @Description 处理掉QQ网名中的特殊表情
     * @Author xw
     * @Date 11:26 2020/2/21
     * @Param [str]
     * @return java.lang.String
     **/
    public String removeNonBmpUnicode(String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("[^\\u0000-\\uFFFF]", "");
        if ("".equals(str)) {
            str = "($ _ $)";
        }
        return str;
    }
}