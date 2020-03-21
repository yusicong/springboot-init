package com.cocacola.yusicong.alllearning.domain.common;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Create by idea
 * 通用分页查询对象
 *
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
    @NotNull(message = "页号不能为空！")
    @Min(value = 0, message = "页号必须为正整数！")
    private Integer pageNo = 1;

    /**
     * 每页条数
     * 默认20条
     */
    @NotNull(message = "每页条数不能为空！")
    @Max(value = 100, message = "每页条数不能超过100条！")
    private Integer pageSize = 20;

    /**
     * 动态查询条件
     */
    @Valid//级联校验 进入实体内部进行校验
    @NotNull(message = "动态查询参数不能为空")
    private T query;

}
