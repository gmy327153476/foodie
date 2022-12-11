package com.soft.controller;


import com.soft.common.ResponseResult;
import com.soft.pojo.VO.UserAddressVO;
import com.soft.service.IUserAddressService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户地址表  前端控制器
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    @Resource
    private IUserAddressService userAddressService;

    @ApiModelProperty("查询用户地址")
    @RequestMapping(value = "/getUserAddress", method = RequestMethod.GET)
    public ResponseResult getUserAddress(String userId) {
        return ResponseResult.successResult(userAddressService.getUserAddress(userId));
    }

    @ApiModelProperty(value = "新增用户地址")
    @RequestMapping(value = "/addUserAddress", method = RequestMethod.POST)
    public ResponseResult addUserAddress(@RequestBody UserAddressVO userAddressVO) {
        return userAddressService.addUserAddress(userAddressVO);
    }

    @ApiModelProperty(value = "删除用户地址")
    @RequestMapping(value = "/deleteUserAddress", method = RequestMethod.GET)
    public ResponseResult deleteUserAddress(String id) {
        return userAddressService.deleteUserAddress(id);
    }

    @ApiModelProperty(value = "修改用户地址")
    @RequestMapping(value = "/updateUserAddress", method = RequestMethod.POST)
    public ResponseResult updateUserAddress(@RequestBody UserAddressVO userAddressVO) {
        return userAddressService.updateUserAddress(userAddressVO);
    }

    @ApiModelProperty("设置默认地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "地址id", required = true, dataType = "String")
    })
    @RequestMapping(value = "setDefalutAddress", method = RequestMethod.POST)
    public ResponseResult setDefalutAddress(@RequestBody UserAddressVO userAddressVO) {
        return userAddressService.setDefalutAddress(userAddressVO);
    }
}

