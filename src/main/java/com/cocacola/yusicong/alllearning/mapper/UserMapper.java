package com.cocacola.yusicong.alllearning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cocacola.yusicong.alllearning.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 22:31
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
