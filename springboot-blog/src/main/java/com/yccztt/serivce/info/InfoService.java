package com.yccztt.serivce.info;

import com.yccztt.domain.info.Info;
import java.util.List;

/**
 * @author hyz
 * @create 2021-06-14 下午5:36
 */
public interface InfoService {

    List<Info> queryInfo();

    void addView();
}
