package com.soft.pojo.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2021/10/28 14:21
 */
@ApiModel(value = "用户表BO", description = "用户信息数据封装")
public class UserParamVO {

    @ApiModelProperty(value = "用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "用户密码")
    @NotNull(message = "密码不能为空")
    @Length(min = 6,message = "密码长度小于六位")
    private String password;

    @ApiModelProperty(value = "确认密码")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
