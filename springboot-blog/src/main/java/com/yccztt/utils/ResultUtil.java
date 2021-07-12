package com.yccztt.utils;

import java.util.HashMap;

/**
 * @author hyz
 * @create 2021-06-14 下午4:38
 */
public class ResultUtil extends HashMap<String,Object> {

    public ResultUtil() {
        put("code",200).put("message","操作成功").put("data",null);
    }

    public static ResultUtil success(String msg) {
        ResultUtil result = new ResultUtil();
        result.put("message",msg);
        return result;
    }

    public static ResultUtil success(Object data) {
        ResultUtil result = new ResultUtil();
        result.put("data",data);
        return result;
    }

    public static ResultUtil success(String msg ,Object data) {
        ResultUtil result = new ResultUtil();
        result.put("message",msg);
        result.put("data",data);
        return result;
    }

    public static ResultUtil success(int code ,String msg ,Object data) {
        ResultUtil result = new ResultUtil();
        result.put("code",code);
        result.put("message",msg);
        result.put("data",data);
        return result;
    }

    public static ResultUtil success(int code,Object data) {
        ResultUtil result = new ResultUtil();
        result.put("code",code);
        result.put("data",data);
        return result;
    }

    public static ResultUtil success() {
        return new ResultUtil();
    }

    public static ResultUtil error(int code ,String msg ,Object data) {
        ResultUtil result = new ResultUtil();
        result.put("code",code);
        result.put("message",msg);
        result.put("data",data);
        return result;
    }

    public static ResultUtil error(int code ,Object data) {
        return error(code,"操作失败",data);
    }

    public static ResultUtil error(Object data) {
        return error(1,"操作失败",data);
    }

    public static ResultUtil error(String msg) {
        return error(1,msg,null);
    }

    public static ResultUtil error(int code ,String msg ) {
        return error(1,msg,null);
    }

    public static ResultUtil error(String msg ,Object data) {
        return error(1,msg,data);
    }

    /**
     * 插入数据:自定义key
     * @param key
     * @param value
     * @return
     */
    public ResultUtil put(String key ,Object value) {
        super.put(key,value);
        return this;
    }

    /**
     * 插入数据:data
     * @param value
     * @return
     */
    public ResultUtil putData(Object value) {
        super.put("data",value);
        return this;
    }
}
