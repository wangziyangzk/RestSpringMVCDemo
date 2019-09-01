package com.wzy.service.Impl;

import com.wzy.service.UserService;
import com.wzy.mapper.UserMapper;
import com.wzy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public boolean login(String uname, String passwd) {
        User user = userMapper.findUserByUname(uname,passwd);
        return user==null?false:true;
    }

    @Transactional
    public void addUser(User user) {
        userMapper.saveUser(user);
    }

    public Object getUser(int id) {
        return userMapper.findUserByUid(id);
    }
}
