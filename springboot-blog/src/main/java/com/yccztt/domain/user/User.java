package com.yccztt.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户
 * @author hyz
 * @create 2021-06-15 下午12:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "b_user") //对应数据库表
public class User {
    @Id                     //没ID会报错
    @Column(name = "id")    //对应列名
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "roles")
    private String roles;

    @Column(name = "perms")
    private String perms;

    @Column(name = "create_time")
    private String create_time;

    @Column(name = "update_time")
    private String update_time;
}
