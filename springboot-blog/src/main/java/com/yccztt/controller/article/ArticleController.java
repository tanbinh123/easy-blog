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
     * 上传图片
     * @param image
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadImg")
    public ResultUtil uploadImg(@RequestParam("image") MultipartFile image, HttpServletRequest request) throws IOException {
        //上传路径保存设置
        //获得SpringBoot当前项目的路径：System.getProperty("user.dir")
        String basePath = System.getProperty("user.dir")+"/upload/blog/";

        //添加新增日期文件夹区分
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String filePath = sdf.format(new Date());

        //判断文件夹是否存在，不存在则创建
        File realPath = new File(basePath + filePath);
        if (!realPath.exists()){
            realPath.mkdirs();
        }

        //使用UUID设置文件名
        String imgName = UuidUtil.getUUID();

        try {
            File newFile = new File(realPath, imgName);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            image.transferTo(newFile);

            String img_url = "http://localhost:8081/upload/blog/"+filePath+"/"+ imgName;
            return ResultUtil.success(img_url);
        } catch (IOException e){
            return ResultUtil.error(e);
        }
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
