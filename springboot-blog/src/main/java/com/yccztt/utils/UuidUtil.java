package com.yccztt.utils;

import java.util.UUID;

/**
 * @author hyz
 * @create 2021-06-14 下午5:10
 */
public class UuidUtil {

    /**
     * 生成UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    /**
     * 随机生成
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getUUID());
    }

}
