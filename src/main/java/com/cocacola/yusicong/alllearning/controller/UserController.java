package com.cocacola.yusicong.alllearning.controller;

import com.cocacola.yusicong.alllearning.domain.common.PageQuery;
import com.cocacola.yusicong.alllearning.domain.common.PageResult;
import com.cocacola.yusicong.alllearning.domain.common.ResponseResult;
import com.cocacola.yusicong.alllearning.domain.dto.UserDTO;
import com.cocacola.yusicong.alllearning.domain.dto.UserQueryDTO;
import com.cocacola.yusicong.alllearning.domain.vo.UserVO;
import com.cocacola.yusicong.alllearning.exception.ErrorCodeEnum;
import com.cocacola.yusicong.alllearning.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 21:16
 */
@RestController
@RequestMapping("api/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户信息
     *
     * @param userDTO 用户信息实体
     * @return 更新结果
     */
    @PostMapping()
    public ResponseResult<String> save(@RequestBody UserDTO userDTO) {
        int save = userService.save(userDTO);
        if (save == 1) {
            return ResponseResult.success("新增成功!");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.INSERT_FAILURE);
        }
    }

    /**
     * 跟新用户信息
     *
     * @param id      用户id
     * @param userDTO 用户信息实体
     * @return 跟心结果
     */
    @PutMapping("/{id}")
    public ResponseResult<String> update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        int update = userService.update(id, userDTO);
        if (update == 1) {
            return ResponseResult.success("更新成功");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.UPDATE_FAILURE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseResult<String> delete(@PathVariable("id") Long id) {
        int delete = userService.delete(id);
        if (delete == 1) {
            return ResponseResult.success("删除成功！");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.DELETE_FAILURE);
        }
    }

    @GetMapping
    public ResponseResult<PageResult> quert(Integer pageNo, Integer pageSize, UserQueryDTO userQueryDTO) {

        PageQuery<UserQueryDTO> pageQuery = new PageQuery<>();
        pageQuery.setPageNo(pageNo);
        pageQuery.setPageSize(pageSize);
        pageQuery.setQuery(userQueryDTO);
        PageResult<List<UserDTO>> pageResult = userService.query(pageQuery);


        List<UserVO> userVOList = Optional.ofNullable(pageResult.getData())
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(userDTO -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(userDTO, userVO);
                    userVO.setPassword("*******");
                    userVO.setPhone(userDTO.getPhone().replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3"));
                    return userVO;
                }).collect(Collectors.toList());

        PageResult<List<UserVO>> result = new PageResult<>();
        BeanUtils.copyProperties(pageResult, result);
        result.setData(userVOList);
        return ResponseResult.success(result);
    }

}
