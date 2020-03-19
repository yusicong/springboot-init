package com.cocacola.yusicong.alllearning.domain.vo;

import lombok.Data;

/**
 * Create by idea
 * 展示层实体
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 21:12
 */
@Data
public class UserVO {

    /*用户主信息*/
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;
}
