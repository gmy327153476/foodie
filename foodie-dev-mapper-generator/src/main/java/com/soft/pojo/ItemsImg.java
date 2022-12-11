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
 * 商品图片 
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@TableName("items_img")
@ApiModel(value = "ItemsImg对象", description = "商品图片 ")
public class ItemsImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图片主键")
    private String id;

    @ApiModelProperty("商品外键id 商品外键id")
    private String itemId;

    @ApiModelProperty("图片地址 图片地址")
    private String url;

    @ApiModelProperty("顺序 图片顺序，从小到大")
    private Integer sort;

    @ApiModelProperty("是否主图 是否主图，1：是，0：否")
    private Integer isMain;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


}
