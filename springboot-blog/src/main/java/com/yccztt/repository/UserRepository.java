package com.yccztt.repository;

import com.yccztt.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hyz
 * @create 2021-06-14 下午5:41
 */
public interface UserRepository extends JpaRepository<User,String> , JpaSpecificationExecutor<User> {
    User findByUsernameAndPassword(String username,String password);

    User queryUserById(String id);
}
