package com.cocacola.yusicong.alllearning.domain.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by idea
 * 通用分页查询对象
 * @author yusicong
 * @date 2020/3/17
 * @time 23:18
 */
@Data
public class PageQuery<T> implements Serializable {

    /**
     * 当前页号
     * 默认第1页
     */
    private Integer pageNo = 1;

    /**
     * 每页条数
     * 默认20条
     */
    private Integer pageSize = 20;

    /**
     * 动态查询条件
     */
    private T query;

}
