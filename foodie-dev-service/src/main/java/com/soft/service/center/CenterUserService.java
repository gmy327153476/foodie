package com.soft.service.center;

import com.soft.common.ResponseResult;
import com.soft.pojo.VO.UserVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-17:04
 * @Description:
 */
public interface CenterUserService {
    /**
     * 个人中心用户信息
     * @param userId
     * @return
     */
    ResponseResult userInfo(String userId);

    /**
     * 查询用户中心地址
     * @param userId
     * @return
     */
    ResponseResult findUserAddress(String userId);

    /**
     * 修改/新增用户信息
     * @param userVO
     * @param request
     * @param response
     * @return
     */
    ResponseResult upsert(UserVO userVO, HttpServletRequest request, HttpServletResponse response);

    /**
     * 头像上传
     * @param file
     * @return
     */
    ResponseResult upload(MultipartFile file);
}
