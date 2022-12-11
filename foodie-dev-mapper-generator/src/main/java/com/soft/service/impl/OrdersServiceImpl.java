package com.soft.service.impl;

import com.soft.pojo.Orders;
import com.soft.mapper.OrdersMapper;
import com.soft.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表; 服务实现类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
