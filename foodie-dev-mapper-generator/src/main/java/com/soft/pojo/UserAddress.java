package com.soft.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户地址表 
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@TableName("user_address")
@ApiModel(value = "UserAddress对象", description = "用户地址表 ")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地址主键id")
    private String id;

    @ApiModelProperty("关联用户id")
    private String userId;

    @ApiModelProperty("收件人姓名")
    private String receiver;

    @ApiModelProperty("收件人手机号")
    private String mobile;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("区县")
    private String district;

    @ApiModelProperty("详细地址")
    private String detail;

    @ApiModelProperty("扩展字段")
    private String extand;

    @ApiModelProperty("是否默认地址")
    private Integer isDefault;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


}
