package com.wzy.controller;

import com.wzy.annotation.IgnoreSecurity;
import com.wzy.resource.Response;
import com.wzy.service.UserService;
import com.wzy.model.User;
import com.wzy.token.TokenManager;
import jdk.nashorn.internal.parser.Token;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    public static final String DEFAULT_TOKEN_NAME = "X-Token";

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;

    /*
    **  获取指定id的用户
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET,produces = "application/json")
    public User getUser(@PathVariable("id")int id){
        User user = (User)userService.getUser(id);
        log.debug("查询用户" + user);
        return user;
    }

    /*
    **  添加指定id的用户
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json",
            consumes = "application/json")
    public User addUser(@RequestBody @Valid User user) {
        userService.addUser(user);
        log.debug("添加用户 :" + user);
        return user;
    }

    /*
    **  登录处理
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @IgnoreSecurity
    public Response login(@RequestParam("username") String uname,
                          @RequestParam("password") String password,
                          HttpServletResponse response){
        boolean flag = userService.login(uname,password);
        if(flag){
            String token = tokenManager.createToken(uname);
            Cookie cookie = new Cookie(DEFAULT_TOKEN_NAME, token);
            log.debug("Login Success");
            return new Response().success();
        }else{
            return new Response().failure("login failure");
        }
    }




}
