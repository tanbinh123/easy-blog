package com.yccztt.controller.article;

import com.yccztt.domain.article.Article;
import com.yccztt.entity.article.ArticleRes;
import com.yccztt.serivce.article.ArticleService;
import com.yccztt.utils.ResultUtil;
import com.yccztt.utils.UuidUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println("查询所有博客：queryBlogs");
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
        System.out.println("根据ID查询博客====> queryBlogById："+id);
        //查看后阅读量+1
        articleService.addReading(id);
        Article article = articleService.queryBlogById(id);
        return ResultUtil.success(article);
    }

    /**
     * 根据标签查询博客
     * @param label
     * @return
     */
    @PostMapping("/blogs/label")
    public ResultUtil queryBlogByLabel(@RequestBody String label) {
        System.out.println("根据标签查询博客====> queryBlogByLabel："+label);
        List<Article> articles = articleService.queryBlogsByLabel(label);
        return ResultUtil.success(articles);
    }

    /**
     * 保存/修改博客
     * @return
     */
    @PostMapping("/save")
    public ResultUtil saveBlog(@RequestBody ArticleRes articleRes) {
        System.out.println("保存/修改博客====> saveBlog");
        String id = articleRes.getId();

        //更新时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String updateDate = sdf.format(new Date());

        //复制数据到更新类
        Article article = new Article();
        BeanUtils.copyProperties(articleRes, article);

        if (id==null||id.equals("")) {
            article.setId(UuidUtil.getUUID());
            article.setReadable("Y");
            article.setCreate_time(updateDate);
            article.setUpdate_time(updateDate);
        } else {
            article.setUpdate_time(updateDate);
        }

        Article saveBlog = articleService.saveBlog(article);
        if (saveBlog!=null) {
            return ResultUtil.success("保存成功");
        } else {
            return ResultUtil.error("保存失败");
        }
    }


   /**
     * 删除博客，不是真正删除，改变状态
     * @return
     */
    @PostMapping("/delete")
    public ResultUtil deleteBlogById(@RequestBody String bid) {
        System.out.println("删除博客====> deleteBlogById："+bid);
        articleService.deleteBlogById(bid);
        return ResultUtil.success();
    }
}
