package com.yccztt.controller.info;

import com.yccztt.domain.info.Info;
import com.yccztt.entity.info.InfoRes;
import com.yccztt.serivce.info.InfoService;
import com.yccztt.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-14 下午8:14
 */
@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    InfoService infoService;

    /**
     * 打开首页显示信息,浏览量+1
     * @return
     */
    @GetMapping("/showInfo")
    public ResultUtil showInfo() {
        List<Info> infos = infoService.queryInfo();
        InfoRes infoRes = new InfoRes();
        BeanUtils.copyProperties(infos.get(0),infoRes);
        //infoService.addView();
        return ResultUtil.success(infoRes);
    }

}
