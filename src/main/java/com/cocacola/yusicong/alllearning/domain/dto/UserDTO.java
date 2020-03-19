package com.cocacola.yusicong.alllearning.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Create by idea
 * 传输层实体
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 20:55
 */
@Data
@AllArgsConstructor
public class UserDTO implements Serializable {
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

    /**
     * 数据版本号
     */
    private Long version;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String email, int age, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }
}
