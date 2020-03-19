package com.cocacola.yusicong.alllearning.service;

import com.cocacola.yusicong.alllearning.domain.common.PageQuery;
import com.cocacola.yusicong.alllearning.domain.common.PageResult;
import com.cocacola.yusicong.alllearning.domain.dto.UserDTO;
import com.cocacola.yusicong.alllearning.domain.dto.UserQueryDTO;

import java.util.List;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 23:13
 */
public interface UserService {

    /**
     * 新增
     *
     * @param userDTO 用户实体
     * @return 结果
     */
    int save(UserDTO userDTO);

    /**
     * 更新
     *
     * @param id      用户id
     * @param userDTO 用户实体
     * @return 结果
     */
    int update(Long id, UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 结果
     */
    int delete(Long id);

    /**
     * 分页查询用户信息
     *
     * @param pageQuery 查询条件
     * @return 结果
     */
    PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery);
}
