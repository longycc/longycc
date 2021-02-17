package com.controller;

import com.service.LoginService;
import com.util.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录注册页面
 * @author create by longy
 * @since 2020-11-26
 */
@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * Author longy
     * @return
     */
    @GetMapping("login")
    public String login(){
        return "login";
    }

    /**
     * 传送门
     * @return
     */
    @GetMapping("portal")
    public String index(){
        return "portal";
    }

    /**
     * Author longy
     * 登录
     * @param email
     * @param password
     * @return
     */
    @GetMapping("signin")
    @ResponseBody
    public int login(@RequestHeader("email")String email,
                        @RequestHeader("password")String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        int temp = loginService.selectUser(user);
        return temp;
    }


    @GetMapping("signup")
    @ResponseBody
    public int register(@RequestHeader("username")String username,
                           @RequestHeader("email")String email,
                           @RequestHeader("password")String password){
        User user = new User(username, email, password);
        int state = loginService.addUser(user);
        return state;
    }
}
