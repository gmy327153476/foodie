package com.soft.pojo.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Mengyuan Guo
 * @Description: 商品评价VO
 * @Date: 2021/12/6 17:13
 */
@Data
public class ItemCommentVO implements Serializable {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像")
    private String face;

    @ApiModelProperty("商品名称")
    private String itemName;

    @ApiModelProperty("分类名称")
    private String sepcName;

    @ApiModelProperty("评价内容")
    private String content;

    @ApiModelProperty("评论更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date updatedTime;

    @ApiModelProperty("全部评价数量")
    private Integer commentTotal;

    @ApiModelProperty("好评数量")
    private Integer goodCommentNum;

    @ApiModelProperty("中评数量")
    private Integer midCommentNum;

    @ApiModelProperty("差评数量")
    private Integer badCommentNum;
}
