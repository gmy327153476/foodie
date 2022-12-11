package com.soft.controller.center;

import com.soft.common.ResponseResult;
import com.soft.pojo.VO.CenterOrderVO;
import com.soft.service.center.CenterOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: Mengyuan Guo
 * @Description: 个人中心支付
 * @Date: 2022/3/16 18:53
 */
@RestController
@RequestMapping("/pay")
public class CenterPayController {
    @Resource
    private CenterOrderService centerOrderService;

    @ApiOperation("订单支付")
    @PostMapping("/centerOrderPay")
    public ResponseResult orderPay(@RequestBody CenterOrderVO centerOrderVO) {
        return centerOrderService.orderPay(centerOrderVO);
    }

    @ApiOperation("支付回调地址")
    @PostMapping("/notifyUrl")
    public String notifyUrl(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        return centerOrderService.notifyUrl(parameterMap);
    }
}
