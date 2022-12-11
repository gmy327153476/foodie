package com.soft.mapper;

import com.soft.pojo.OrderStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单状态表;订单的每个状态更改都需要进行记录
10：待付款  20：已付款，待发货  30：已发货，待收货（7天自动确认）  40：交易成功（此时可以评价）50：交易关闭（待付款时，用户取消 或 长时间未付款，系统识别后自动关闭）
退货/退货，此分支流程不做，所以不加入 Mapper 接口
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Mapper
public interface OrderStatusMapper extends BaseMapper<OrderStatus> {

}
