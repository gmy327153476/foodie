package com.soft.pojo.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2021/11/2 10:24
 */
@ApiModel(value = "用户表VO")
@Data
public class UserVO implements Serializable {

    @ApiModelProperty("主键id 用户id")
    private String id;

    @ApiModelProperty("用户名 用户名")
    private String username;

    @ApiModelProperty("昵称 昵称")
    private String nickname;

    @ApiModelProperty("头像")
    private String face;

    @ApiModelProperty("性别 性别 1:男  0:女  2:保密")
    private Integer sex;

    @ApiModelProperty("生日 生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("邮箱地址")
    private String email;

}
