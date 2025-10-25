package com.architectexpress.interfaces;

public interface AuthService {
    boolean isAuthorized(String username, String password);
}
