package com.yccztt.entity.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyz
 * @create 2021-06-14 下午5:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoRes {
    private Integer id;         //ID
    private String createTime;  //创建日期
    private Integer viewNum;    //浏览次数
}
