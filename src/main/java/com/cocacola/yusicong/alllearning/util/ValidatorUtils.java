package com.cocacola.yusicong.alllearning.util;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Create by idea
 * 校验工具类，实现手动校验
 *
 * @author yusicong
 * @date 2020/3/21
 * @time 16:58
 */
public class ValidatorUtils {
    /**
     * 校验器
     */
    private static Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 参数校验
     *
     * @param object 校验对象
     * @param groups 校验分组
     * @param <T>    校验对象类
     */
    public static <T> void validate(T object, Class... groups) {
        Set<ConstraintViolation<T>> validate = validator.validate(object, groups);
        if (!CollectionUtils.isEmpty(validate)) {
            StringBuilder exceptionMessage = new StringBuilder();
            validate.forEach(constraintViolation -> {
                exceptionMessage.append(constraintViolation.getMessage());
            });
            throw new RuntimeException(exceptionMessage.toString());
        }
    }
}
