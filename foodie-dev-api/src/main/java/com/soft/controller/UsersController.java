package com.soft.controller;


import com.soft.common.CookieUtils;
import com.soft.common.ResponseResult;
import com.soft.pojo.VO.UserParamVO;
import com.soft.pojo.Users;
import com.soft.service.IUsersService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 用户表  前端控制器
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService userService;

    @ApiModelProperty("/查询所有用户")
    @GetMapping("/findUsers")
    public List<Users> findUsers() {
        List<Users> usersList =  userService.findUsers();
        return usersList;
    }

    @ApiModelProperty("/用户名验证")
    @PostMapping("/verifyUsername")
    public ResponseResult verifyUsername(@RequestBody String username) {
        if(StringUtils.isEmpty(username)) {
            return ResponseResult.errorResult("用户名为空");
        }
        return userService.verifyUsername(username);
    }

    @ApiModelProperty("用户注册")
    @PostMapping("/registerUser")
    public ResponseResult registerUser(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated UserParamVO userParamVO) {
        return userService.registerUser(request, response, userParamVO);
    }

    @ApiModelProperty(value = "用户登录")
    @PostMapping("/login")
    public ResponseResult login(HttpServletRequest request, HttpServletResponse response,@RequestBody @Validated UserParamVO userParamVO) {
        return userService.login(request, response, userParamVO);
    }

    @ApiOperation(value = "/用户退出登录")
    @RequestMapping(value = "/logoutUser", method = RequestMethod.GET)
    public ResponseResult logoutUser(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "user");
        return ResponseResult.successResult();
    }
}

