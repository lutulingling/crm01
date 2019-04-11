package com.lyk.crm.settings.controller;

import com.lyk.crm.settings.domain.User;
import com.lyk.crm.settings.service.UserService;
import com.lyk.crm.settings.service.impl.UserServiceImpl;
import com.lyk.crm.utils.Constans;
import com.lyk.crm.utils.MD5Util;
import com.lyk.crm.utils.PrintJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("setting/user")
public class UserController {
    @Autowired
   private UserService userService;

    @RequestMapping("/login.do")
    private Object login(HttpServletRequest request, HttpServletResponse response,
                        Model model,
                        @RequestParam(value = "loginAct") String loginAct,
                       @RequestParam(value = "loginPwd")String loginPwd){

        System.out.println("进入usercontroller");

        String ip = request.getRemoteAddr();
        loginPwd = MD5Util.getMD5(loginPwd);

        System.out.println(loginAct);
        System.out.println(loginPwd);
        System.out.println(ip);

        User user = (User) userService.getUser(loginAct,loginPwd,ip);

        String userIP = user.getAllowIps();

        Map<String,Object> map = new HashMap<>();

        if (null == user){
            map.put(Constans.MSG,"用户名或密码错误");
        }else if (user.getAllowIps()!= ip){
            map.put(Constans.MSG,"IP地址受限");
        }else {
            map.put(Constans.MSG,"OK");
        }

        return map;

    }



}
