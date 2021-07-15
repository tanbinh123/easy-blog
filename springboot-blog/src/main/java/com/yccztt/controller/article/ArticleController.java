package com.yccztt.controller.article;

import com.yccztt.domain.article.Article;
import com.yccztt.entity.article.ArticleRes;
import com.yccztt.serivce.article.ArticleService;
import com.yccztt.utils.ResultUtil;
import com.yccztt.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @PostMapping("/blogs")
    public ResultUtil queryBlogById(@RequestBody String id) {
        Article article = articleService.queryBlogById(id);
        return ResultUtil.success(article);
    }

    /**
     * 保存/修改博客
     * @return
     */
    @PostMapping("/save")
    public ResultUtil saveBlog(@RequestBody ArticleRes articleRes) {
        return ResultUtil.success();
    }


   /**
     * 删除博客，不是真正删除，改变状态
     * @return
     */
    @PostMapping("/delete")
    public ResultUtil deleteBlogById(@RequestBody String bid) {
        articleService.deleteBlogById(bid);
        return ResultUtil.success();
    }
}
