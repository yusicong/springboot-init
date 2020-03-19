package com.cocacola.yusicong.alllearning.domain.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 21:55
 */
@Data
public class PageResult<T> implements Serializable {

    /**
     * 当前页号
     */
    private Integer pageNo;

    /**
     * 每页行数
     */
    private Integer pageSize;

    /**
     * 总数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long pageNum;

    /**
     * 数据信息
     */
    private T data;
}
