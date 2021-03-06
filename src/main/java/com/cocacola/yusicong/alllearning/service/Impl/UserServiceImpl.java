package com.cocacola.yusicong.alllearning.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cocacola.yusicong.alllearning.domain.common.PageQuery;
import com.cocacola.yusicong.alllearning.domain.common.PageResult;
import com.cocacola.yusicong.alllearning.domain.dto.UserDTO;
import com.cocacola.yusicong.alllearning.domain.dto.UserQueryDTO;
import com.cocacola.yusicong.alllearning.domain.entity.UserDO;
import com.cocacola.yusicong.alllearning.mapper.UserMapper;
import com.cocacola.yusicong.alllearning.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 23:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int save(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        //todo 浅拷贝属性名相同才可以拷贝
        BeanUtils.copyProperties(userDTO, userDO);
        return userMapper.insert(userDO);
    }

    @Override
    public int update(Long id, UserDTO userDTO) {
        UserDO userDO = new UserDO();
        //todo 浅拷贝属性名相同才可以拷贝
        BeanUtils.copyProperties(userDTO, userDO);
        userDO.setId(id);
        return userMapper.updateById(userDO);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery) {
        //参数构造
        Page page = new Page(pageQuery.getPageNo(), pageQuery.getPageSize());
        UserDO query = new UserDO();
        BeanUtils.copyProperties(pageQuery.getQuery(), query);
        QueryWrapper queryWrapper = new QueryWrapper(query);
        //查询
        IPage<UserDO> userDOIPage = userMapper.selectPage(page, queryWrapper);

        //结果解析
        PageResult<List<UserDTO>> pageResult = new PageResult<>();
        pageResult.setPageNo((int) userDOIPage.getCurrent());
        pageResult.setPageSize((int) userDOIPage.getSize());
        pageResult.setTotal(userDOIPage.getTotal());
        pageResult.setPageNum(userDOIPage.getPages());

        //对数据进行转换
        List<UserDTO> userDTOList = Optional
                .ofNullable(userDOIPage.getRecords())
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(userDO -> {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(userDO, userDTO);
                    return userDTO;
                })
                .collect(Collectors.toList());

        pageResult.setData(userDTOList);
        return pageResult;
    }
}
