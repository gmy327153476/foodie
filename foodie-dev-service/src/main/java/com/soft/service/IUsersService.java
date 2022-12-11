package com.soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.common.ResponseResult;
import com.soft.pojo.VO.UserParamVO;
import com.soft.pojo.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 用户表  服务类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
public interface IUsersService extends IService<Users> {

    /**
     * 查询所有用户
     * @return
     */
    List<Users> findUsers();

    /**
     * 验证用户名是否存在
     * @return
     */
    ResponseResult verifyUsername(String username);

    /**
     * 用户注册
     */
    ResponseResult registerUser(HttpServletRequest request, HttpServletResponse response, UserParamVO userParamVO);

    /**
     * 用户登录
     */
    ResponseResult login(HttpServletRequest request, HttpServletResponse response, UserParamVO userParamVO);

}
