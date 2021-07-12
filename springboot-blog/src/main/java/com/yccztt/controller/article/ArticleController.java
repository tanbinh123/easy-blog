package com.yccztt.controller.article;

import com.yccztt.domain.article.Article;
import com.yccztt.serivce.article.ArticleService;
import com.yccztt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-19 下午11:27
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 查询所有博客
     * @return
     */
    @GetMapping("/list")
    public ResultUtil queryBlogs() {
        List<Article> articles = articleService.queryBlogs();
        return ResultUtil.success(articles);
    }

    /**
     * 根据ID查询博客
     * @param id
     * @return
     */
    @GetMapping("/blogs/{id}")
    public ResultUtil queryBlogById(@PathVariable("id") String id) {
        Article article = articleService.queryBlogById(id);
        return ResultUtil.success(article);
    }
}
