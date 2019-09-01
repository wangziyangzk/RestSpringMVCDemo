package com.wzy.service;

import com.wzy.model.User;

/*
**  对业务逻辑进行抽象，体现了面向接口编程的思想
 */
public interface UserService {

    /*
    **  用户登录
     */
    public boolean login(String uname,String passwd);

    /*
    **  用户注册
     */
    public void addUser(User user);

    /*
    **  用户获取逻辑
     */
    public Object getUser(int id);
}





























