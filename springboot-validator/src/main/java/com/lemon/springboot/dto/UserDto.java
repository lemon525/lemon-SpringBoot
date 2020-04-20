package com.lemon.springboot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private Integer id;

    @NotNull(message = "用户名不能为空")
    @Length(max = 16, message = "用户名不能超过16个字符")
    @ApiModelProperty("用户名")
    private String username;

    @NotNull(message = "密码不能为空")
    @Length(min = 6, message = "密码不能小于6位")
    @ApiModelProperty("密码")
    private String password;

    @NotNull()
    @ApiModelProperty("昵称")
    private String nickName;
}
