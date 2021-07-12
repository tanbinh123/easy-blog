package com.yccztt.utils;

import java.security.MessageDigest;

/**
 * @author hyz
 * @create 2021-06-14 下午4:22
 */
public class MD5Util {

    /**
     * 加密
     * @param text
     * @return
     */
    public static String encrypt(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //update处理
            md.update(text.getBytes());
            //调用该方法完成计算
            byte [] mdByte = md.digest();

            int i;
            StringBuffer encryptText = new StringBuffer("");
            //做相应的转化（十六进制）
            for (int offset = 0; offset < mdByte.length; offset++) {
                i = mdByte[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    encryptText.append("0");
                }
                encryptText.append(Integer.toHexString(i));
            }
            return encryptText.toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    //测试
    public static void main(String[] args) {
        System.out.println(MD5Util.encrypt("123456"));
    }

}
