package com.cocacola.yusicong.alllearning.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.FileFilter;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Create by idea
 * 数据库实体
 *
 * @author yusicong
 * @date 2020/3/4
 * @time 23:35
 */
@Data
@TableName("user")
public class UserDO implements Serializable {


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

    /*系统主信息*/

    /**
     * 数据库主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime created;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modified;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String creator;

    /**
     * 修改者
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String operator;

    /**
     * 逻辑删除字段 0：正常 1：逻辑删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    /**
     * 数据版本号
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Long version;
}
