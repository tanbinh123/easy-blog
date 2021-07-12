package com.yccztt.serivce.user.impl;

import com.yccztt.domain.user.User;
import com.yccztt.repository.UserRepository;
import com.yccztt.serivce.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-15 下午1:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> queryUser() {
        return userRepository.findAll();
    }

    @Override
    public User login(String username,String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User queryUserById(String userId) {
        return userRepository.queryUserById(userId);
    }
}
