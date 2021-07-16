package com.yccztt.controller.file;

import com.yccztt.utils.ResultUtil;
import com.yccztt.utils.UuidUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author hyz
 * @Date 2021/7/15
 */
@RestController
@RequestMapping("/api/file")
public class FileController {

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

        //获取图片后缀
        String suffix = getFileNameSuffix(image.getOriginalFilename());

        //使用UUID设置文件名
        String imgName = UuidUtil.getUUID()+"."+suffix;

        try {
            File newFile = new File(realPath, imgName);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            image.transferTo(newFile);

            String img_url = "http://localhost:8081/upload/blog/"+filePath+"/"+ imgName;
            return ResultUtil.success().put("url", img_url);
        } catch (IOException e){
            return ResultUtil.error(e);
        }
    }

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public String getFileNameSuffix(String fileName) {
        String substring = fileName.substring(fileName.lastIndexOf(".") + 1);
        return substring;
    }

}
