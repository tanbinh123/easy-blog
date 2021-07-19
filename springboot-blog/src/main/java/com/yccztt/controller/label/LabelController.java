package com.yccztt.controller.label;

import com.yccztt.domain.article.Article;
import com.yccztt.domain.label.Label;
import com.yccztt.serivce.article.ArticleService;
import com.yccztt.serivce.label.LabelService;
import com.yccztt.utils.ResultUtil;
import com.yccztt.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author hyz
 * @create 2021-07-04 下午4:00
 */
@RestController
@RequestMapping("/api/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @Autowired
    ArticleService articleService;

    /**
     * 查询所有标签
     * @return
     */
    @GetMapping("/list")
    public ResultUtil queryLabel() {
        System.out.println("查询所有标签====> queryLabel");
        List<Label> labelList = labelService.queryLabel();
        return ResultUtil.success(labelList);
    }

    /**
     * 新增标签
     * @param label
     * @return
     */
    @GetMapping("/add/{label}")
    public ResultUtil addLabel(@PathVariable("label") String label) {
        System.out.println("新增标签====> addLabel："+label);
        Label labelByName = labelService.queryLabelByName(label);
        if (labelByName==null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String createDate = sdf.format(new Date());
            Label label1 = new Label(UuidUtil.getUUID(),label,createDate,createDate);
            labelService.addLabel(label1);
            return ResultUtil.success();
        } else {
            return ResultUtil.error("已存在该标签");
        }
    }

    /**
     * 删除标签
     * @param labelId
     * @param labelName
     * @return
     */
    @GetMapping("/delete/{labelId}/{labelName}")
    public ResultUtil deleteLabel(@PathVariable("labelId") String labelId,
                                  @PathVariable("labelName") String labelName) {
        System.out.println("删除标签====> deleteLabel："+labelId+"，"+labelName);
        List<Article> articles = articleService.queryBlogsByLabel(labelName);
        if (!articles.isEmpty()) {
            return ResultUtil.error("改标签存在文章，无法删除");
        } else {
            labelService.deleteLabel(labelId);
            return ResultUtil.success();
        }
    }
}
