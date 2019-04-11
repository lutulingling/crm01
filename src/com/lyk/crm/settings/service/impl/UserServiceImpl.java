package com.lyk.crm.settings.service.impl;

import com.lyk.crm.settings.dao.UserDao;
import com.lyk.crm.settings.domain.User;
import com.lyk.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String loaginAct, String loginPwd, String ip){
        Map<String,Object> map = new HashMap<>();

        map.put("loaginAct",loaginAct);
        map.put("loaginPwd",loginPwd);
        map.put("ip",ip);

        User user = userDao.getUser(map);

        return user;
    }
}
