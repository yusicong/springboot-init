package com.cocacola.yusicong.alllearning.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by idea
 * 数据查询DTO
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 21:54
 */
@Data
public class UserQueryDTO implements Serializable {

    /**
     * 用户名
     */
    private String username;

}
