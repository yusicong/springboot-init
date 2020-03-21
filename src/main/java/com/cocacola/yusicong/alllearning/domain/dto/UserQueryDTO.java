package com.cocacola.yusicong.alllearning.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "用户名不能为空！")
    private String username;

}
