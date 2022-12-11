package com.soft.controller.center;

import com.soft.common.ResponseResult;
import com.soft.pojo.VO.UserVO;
import com.soft.service.center.CenterUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-16:56
 * @Description: 用户中心控制器
 */
@RestController
@RequestMapping("/centerUser")
public class CenterUserController {

    @Resource
    private CenterUserService centerUserService;

    @ApiOperation("个人中心用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "用户id", value = "userId", required = true, dataType = "string")
    })
    @GetMapping("/userInfo")
    public ResponseResult userInfo(@RequestParam("userId") String userId) {
        return centerUserService.userInfo(userId);
    }

    @ApiOperation("获取用户中心地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "用户id", value = "userId", required = true, dataType = "string")
    })
    @GetMapping("/findUserAddress")
    public ResponseResult findUserAddress(@RequestParam(value = "userId") String userId) {
        return centerUserService.findUserAddress(userId);
    }

    @ApiOperation("修改/新增用户信息")
    @PostMapping("/upsert")
    public ResponseResult upsert(@RequestBody UserVO userVO, HttpServletRequest request, HttpServletResponse response) {
        return centerUserService.upsert(userVO, request, response);
    }

    @ApiOperation("头像上传")
    @PostMapping("/upload")
    public ResponseResult upload(@RequestParam("file")MultipartFile file) {
        return centerUserService.upload(file);
    }
}
