package com.gloryh.service.Impl;

import com.gloryh.entity.User;
import com.gloryh.repository.LoginRepository;
import com.gloryh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Override
    public User findUser(String username,String role) {
        System.out.println("---"+username+"-------"+role+"-------------11");
        return loginRepository.findUser(username,role);
    }

    @Override
    public int countUser(String username,String role) {
        return loginRepository.countUser(username,role);
    }
}
