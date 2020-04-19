package org.xkx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class managerLoginController {

    @RequestMapping("/manegerLogin")
    public String managerLogin(@RequestParam(value = "manager",required=false)String manager,
                               @RequestParam(value = "password",required=false)String password,
                               Model model,
                               HttpSession session){
        if ("sa".equals(manager) && "asd".equals(password)) {
            model.addAttribute("manager", manager);
            session.setAttribute("asd",manager);//给session域中添加一个manager
            return "houtai";
        }else {
            model.addAttribute("msg", "账号或密码错误");
            return "managerlogin";
        }
    }
}
