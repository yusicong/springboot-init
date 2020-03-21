package com.cocacola.yusicong.alllearning.domain.dto;

import com.cocacola.yusicong.alllearning.util.InsertValidationGroup;
import com.cocacola.yusicong.alllearning.util.UpdateValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Create by idea
 * 传输层实体
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 20:55
 */
@Data
@AllArgsConstructor
public class UserDTO implements Serializable {
    /*用户主信息*/
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不可为空!", groups = InsertValidationGroup.class)
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "用户名不可为空!", groups = InsertValidationGroup.class)
    //@Length 字段有值才会校验
    @Length(min = 6, max = 18, message = "密码长度不能少于6位，不能多于18位！")
    private String password;

    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不能为空！", groups = InsertValidationGroup.class)
    @Email(message = "必须为有效邮箱！")
    private String email;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空！", groups = InsertValidationGroup.class)
    @Max(value = 35, message = "最大不能超过35岁")
    @Min(value = 18, message = "最小不能小于18岁")
    private Integer age;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空！", groups = InsertValidationGroup.class)
    private String phone;

    /**
     * 数据版本号
     */
    @NotNull(message = "版本号不能为空！", groups = UpdateValidationGroup.class)
    private Long version;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String email, int age, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }
}
