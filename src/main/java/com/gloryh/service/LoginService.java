package com.gloryh.service;

import com.gloryh.entity.User;

/**
 * @author admin
 */
public interface LoginService {
    public User findUser(String username,String role);

    public int countUser(String username,String role);
}
