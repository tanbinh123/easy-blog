package com.yccztt.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyz
 * @create 2021-06-15 下午1:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {
    private String nickname;        //昵称
    private String avatar;          //头像
    private String email;           //邮箱
    private String phone;           //电话
    private String introduction;    //简介
}
