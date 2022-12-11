package com.soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.common.ResponseResult;
import com.soft.pojo.UserAddress;
import com.soft.pojo.VO.UserAddressVO;

/**
 * <p>
 * 用户地址表  服务类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
public interface IUserAddressService extends IService<UserAddress> {

    /**
     * 获取用户地址
     * @param userId
     * @return
     */
    ResponseResult getUserAddress(String userId);

    /**
     * 新增用户地址
     * @param userAddressVO
     * @return
     */
    ResponseResult addUserAddress(UserAddressVO userAddressVO);

    /**
     * 删除用户地址
     * @param id
     * @return
     */
    ResponseResult deleteUserAddress(String id);

    /**
     * 修改用户地址
     * @param userAddressVO
     * @return
     */
    ResponseResult updateUserAddress(UserAddressVO userAddressVO);

    /**
     * 设置默认地址
     * @param userAddressVO
     * @return
     */
    ResponseResult setDefalutAddress(UserAddressVO userAddressVO);
}
