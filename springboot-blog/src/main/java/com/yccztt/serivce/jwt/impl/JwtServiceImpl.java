package com.yccztt.serivce.jwt.impl;

import com.yccztt.domain.jwt.JWTEntity;
import com.yccztt.repository.JWTEntityRepository;
import com.yccztt.serivce.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author hyz
 * @Date 2021/7/28
 */
@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    JWTEntityRepository jwtEntityRepository;

    /**
     * 保存jwt数据
     * @param entity
     */
    @Transactional
    @Override
    public void saveJwt(JWTEntity entity) {
        jwtEntityRepository.save(entity);
    }

    /**
     * 根据id查询jwt数据
     * @param userId
     * @return
     */
    @Override
    public JWTEntity queryJwt(String userId) {
        JWTEntity entity = jwtEntityRepository.findJWTEntityById(userId);
        return entity;
    }

    /**
     * 删除jwt数据
     * @param userId
     */
    @Transactional
    @Override
    public void deleteJwt(String userId) {
        jwtEntityRepository.deleteJWTEntityById(userId);
    }
}
