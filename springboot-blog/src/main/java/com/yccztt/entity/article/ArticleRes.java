package com.yccztt.entity.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyz
 * @create 2021-06-19 下午11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRes {
    private String id;
    private String title;
    private Integer reading;
    private String label;
    private String cover_img;
    private String content;
    private String readable;
    private String author;
    private String create_time;
    private String update_time;
}
