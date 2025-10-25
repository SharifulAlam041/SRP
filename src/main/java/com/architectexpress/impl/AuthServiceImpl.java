package com.architectexpress.impl;

import com.architectexpress.interfaces.AuthService;

public class AuthServiceImpl implements AuthService {
    @Override
    public boolean isAuthorized(String username, String password) {
        return "admin".equals(username) && "passw0rd".equals(password);
    }
}
