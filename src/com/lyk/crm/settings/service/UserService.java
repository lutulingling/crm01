package com.lyk.crm.settings.service;

import com.lyk.crm.settings.domain.User;

public interface UserService {

    User getUser(String loaginAct, String passWord, String ip);
}
