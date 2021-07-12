package com.yccztt.serivce.user;

import com.yccztt.domain.user.User;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-15 下午1:24
 */
public interface UserService {
    List<User> queryUser();

    User login(String username,String password);

    User queryUserById(String userId);
}
