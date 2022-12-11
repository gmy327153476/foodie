package com.soft.controller.center;

import com.soft.common.ResponseResult;
import com.soft.pojo.VO.CenterOrderVO;
import com.soft.service.center.CenterOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-17:47
 * @Description:
 */
@RestController
@RequestMapping("/centerOrder")
public class CenterOrderController {

    @Resource
    private CenterOrderService centerOrderService;

    @ApiOperation("查询用户中心订单")
    @PostMapping("/findCenterOrder")
    public ResponseResult findCenterOrder(@RequestBody CenterOrderVO centerOrderVO) {
        return centerOrderService.findCenterOrder(centerOrderVO);
    }
}
