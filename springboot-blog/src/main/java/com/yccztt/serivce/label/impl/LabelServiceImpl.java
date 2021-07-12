package com.yccztt.serivce.label.impl;

import com.yccztt.domain.label.Label;
import com.yccztt.repository.LabelRepository;
import com.yccztt.serivce.label.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyz
 * @create 2021-07-04 下午3:57
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelRepository labelRepository;

    @Override
    public List<Label> queryLabel() {
        return labelRepository.findAll();
    }

    @Override
    public Label queryLabelByName(String name) {
        return labelRepository.findByLabel(name);
    }

    @Override
    public void addLabel(Label Label) {
        labelRepository.save(Label);
    }

    @Override
    public void deleteLabel(String labelId) {
        labelRepository.deleteLabel(labelId);
    }
}
