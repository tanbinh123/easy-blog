package com.yccztt.serivce.info.impl;

import com.yccztt.domain.info.Info;
import com.yccztt.repository.InfoRepository;
import com.yccztt.serivce.info.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-14 下午5:43
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    InfoRepository infoRepository;

    @Override
    public List<Info> queryInfo() {
        return infoRepository.findAll();
    }

    @Override
    public void addView() {
        infoRepository.addView();
    }
}
