package com.yccztt.repository;

import com.yccztt.domain.jwt.JWTEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

/**
 * @Author hyz
 * @Date 2021/7/28
 */
public interface JWTEntityRepository extends JpaRepository<JWTEntity,String>, JpaSpecificationExecutor<JWTEntity> {

    JWTEntity findJWTEntityById(String id);

    @Transactional
    @Modifying
    void deleteJWTEntityById(String id);
}
