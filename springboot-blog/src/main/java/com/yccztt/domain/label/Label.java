package com.yccztt.domain.label;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签类
 * @author hyz
 * @create 2021-07-04 下午3:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "b_label") //对应数据库表
public class Label {
    @Id                     //没ID会报错
    @Column(name = "id")    //对应列名
    private String id;

    @Column(name = "label")
    private String label;

    @Column(name = "create_time")
    private String create_time;

    @Column(name = "update_time")
    private String update_time;
}
