package com.cocacola.yusicong.alllearning.controller;

import com.cocacola.yusicong.alllearning.domain.common.PageQuery;
import com.cocacola.yusicong.alllearning.domain.common.PageResult;
import com.cocacola.yusicong.alllearning.domain.common.ResponseResult;
import com.cocacola.yusicong.alllearning.domain.dto.UserDTO;
import com.cocacola.yusicong.alllearning.domain.dto.UserQueryDTO;
import com.cocacola.yusicong.alllearning.domain.vo.UserVO;
import com.cocacola.yusicong.alllearning.exception.ErrorCodeEnum;
import com.cocacola.yusicong.alllearning.service.UserService;
import com.cocacola.yusicong.alllearning.util.InsertValidationGroup;
import com.cocacola.yusicong.alllearning.util.UpdateValidationGroup;
import com.cocacola.yusicong.alllearning.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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
@Validated//基础类型校验开启
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户信息
     *
     * @param userDTO 用户信息实体
     * @return 更新结果
     */
    @PostMapping("/save")
    public ResponseResult<String> save(@Validated(InsertValidationGroup.class) @RequestBody UserDTO userDTO) {
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
    @PutMapping("/update/{id}")
    public ResponseResult<String> update(@NotNull @PathVariable("id") Long id, @Validated(UpdateValidationGroup.class) @RequestBody UserDTO userDTO) {
        int update = userService.update(id, userDTO);
        if (update == 1) {
            return ResponseResult.success("更新成功");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.UPDATE_FAILURE);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult<String> delete(@NotNull(message = "用户id不可为空") @PathVariable("id") Long id) {
        int delete = userService.delete(id);
        if (delete == 1) {
            return ResponseResult.success("删除成功！");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.DELETE_FAILURE);
        }
    }

    @GetMapping("/query")
    public ResponseResult query(@NotNull Integer pageNo, @NotNull Integer pageSize, @Validated UserQueryDTO userQueryDTO) {

        PageQuery<UserQueryDTO> pageQuery = new PageQuery<>();
        pageQuery.setPageNo(pageNo);
        pageQuery.setPageSize(pageSize);
        pageQuery.setQuery(userQueryDTO);
        PageResult<List<UserDTO>> pageResult = userService.query(pageQuery);
        //加入手动校验功能
        ValidatorUtils.validate(pageQuery);

        List<UserVO> userVOList = Optional.ofNullable(pageResult.getData())
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(userDTO -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(userDTO, userVO);
                    userVO.setPassword("*******");
                    if (!StringUtils.isEmpty(userDTO.getPhone())) {
                        userVO.setPhone(userDTO.getPhone().replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3"));
                    }
                    return userVO;
                }).collect(Collectors.toList());

        PageResult<List<UserVO>> result = new PageResult<>();
        BeanUtils.copyProperties(pageResult, result);
        result.setData(userVOList);
        return ResponseResult.success(result);
    }

}
