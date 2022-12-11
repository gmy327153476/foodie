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
 * 商品评价表 
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@TableName("items_comments")
@ApiModel(value = "ItemsComments对象", description = "商品评价表 ")
public class ItemsComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id主键")
    private String id;

    @ApiModelProperty("用户id 用户名须脱敏")
    private String userId;

    @ApiModelProperty("商品id")
    private String itemId;

    @ApiModelProperty("商品名称")
    private String itemName;

    @ApiModelProperty("商品规格id 可为空")
    private String itemSpecId;

    @ApiModelProperty("规格名称 可为空")
    private String sepcName;

    @ApiModelProperty("评价等级 1：好评 2：中评 3：差评")
    private Integer commentLevel;

    @ApiModelProperty("评价内容")
    private String content;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


}
