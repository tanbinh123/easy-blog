package com.yccztt.entity.label;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyz
 * @create 2021-07-04 下午3:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelRes {
    private String id;
    private String label;
    private String create_time;
    private String update_time;
}
