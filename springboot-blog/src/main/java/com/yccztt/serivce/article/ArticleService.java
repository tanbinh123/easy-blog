package com.yccztt.serivce.article;

import com.yccztt.domain.article.Article;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-19 下午11:23
 */
public interface ArticleService {

    List<Article> queryBlogs();

    Article queryBlogById(String bid);

    Article saveBlog(Article article);

    void deleteBlogById(String bid);

    void addReading(String bid);
}
