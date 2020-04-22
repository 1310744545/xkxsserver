package org.xkx.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xkx.pojo.god;
import org.xkx.service.IGodService;


@Controller
public class LoginController {

    @Autowired
    IGodService iGodService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("login")
    public Result login(@RequestBody god god) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();

        //封装登陆数据
        UsernamePasswordToken Token = new UsernamePasswordToken(god.getCount(), god.getPassword());
        try {
            subject.login(Token);//用户登陆
            return new Result(200,iGodService.selectGodByCount(god.getCount()).getId());
        }catch (UnknownAccountException e){//用户名不存在
            return new Result(400);
        }catch (IncorrectCredentialsException e){ //密码错误
            return new Result(400);
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "退出成功";
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addGod")
    public String addGod(@RequestBody god god){
        ByteSource salt = ByteSource.Util.bytes(god.getCount());
        String Result=new SimpleHash("MD5",god.getPassword(),salt,1024).toHex();
        god God=new god();
        God.setCount(god.getCount());
        God.setPassword(Result);
        God.setName(god.getName());
        God.setUrl("空空如也");
        God.setIntroduction("空空如也");
        return iGodService.addGod(God);
    }

}
