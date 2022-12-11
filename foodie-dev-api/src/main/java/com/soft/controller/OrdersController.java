package com.soft.controller;


import com.soft.common.ResponseResult;
import com.soft.pojo.VO.OrderVO;
import com.soft.service.IOrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 订单表; 前端控制器
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    private IOrdersService ordersService;

    @ApiOperation("创建订单")
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public ResponseResult createOrder(@RequestBody OrderVO orderVO) {
        return ordersService.createOrder(orderVO);
    }

    @ApiOperation("支付中心创建订单后，回调该接口，修改本地订单的状态")
    @PostMapping(value = "/notifyMerchantOrderPaid")
    public ResponseResult notifyMerchantOrderPaid(String merchantOrderId) {
        return ordersService.notifyMerchantOrderPaid(merchantOrderId);
    }

}

