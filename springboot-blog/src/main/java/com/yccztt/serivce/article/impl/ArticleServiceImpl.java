package com.yccztt.serivce.article.impl;

import com.yccztt.domain.article.Article;
import com.yccztt.repository.ArticleRepository;
import com.yccztt.serivce.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-19 下午11:25
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> queryBlogs() {
        return articleRepository.queryArticlesByReadable("Y");
    }

    @Override
    public Article queryBlogById(String bid) {
        return articleRepository.getArticleById(bid);
    }

    @Override
    public Article saveBlog(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteBlogById(String bid) {
        articleRepository.deleteBlog(bid);
    }

    @Override
    public void addReading(String bid) {
        articleRepository.addReading(bid);
    }
}
