package com.lyk.crm.settings.dao;

import com.lyk.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    User getUser(Map<String, Object> map);
}
