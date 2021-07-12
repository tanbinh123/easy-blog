package com.yccztt.domain.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 博客
 * @author hyz
 * @create 2021-06-19 下午11:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "b_article") //对应数据库表
public class Article {

    @Id                     //没ID会报错
    @Column(name = "id")    //对应列名
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "reading")
    private Integer reading;

    @Column(name = "label")
    private String label;

    @Column(name = "cover_img")
    private String cover_img;

    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @Column(name = "readable")
    private String readable;

    @Column(name = "author")
    private String author;

    @Column(name = "create_time")
    private String create_time;

    @Column(name = "update_time")
    private String update_time;
}
