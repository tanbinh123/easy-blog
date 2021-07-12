package com.yccztt.serivce.label;

import com.yccztt.domain.label.Label;

import java.util.List;

/**
 * @author hyz
 * @create 2021-07-04 下午3:57
 */
public interface LabelService {

    List<Label> queryLabel();

    Label queryLabelByName(String name);

    void addLabel(Label Label);

    void deleteLabel(String labelId);
}
