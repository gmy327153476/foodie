package com.soft.mapper;

import com.soft.pojo.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表; Mapper 接口
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
