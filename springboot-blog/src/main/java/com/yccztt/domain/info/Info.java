package com.yccztt.domain.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 展示
 * @author hyz
 * @create 2021-06-14 下午5:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "b_info") //对应数据库表
public class Info {
    @Id                     //没ID会报错
    @Column(name = "id")    //对应列名
    private Integer id;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "view_num")
    private Integer viewNum;
}
