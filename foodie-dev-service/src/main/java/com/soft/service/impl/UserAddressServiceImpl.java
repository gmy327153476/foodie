package com.soft.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.common.ResponseResult;
import com.soft.constants.Constants;
import com.soft.mapper.UserAddressMapper;
import com.soft.pojo.UserAddress;
import com.soft.pojo.VO.UserAddressVO;
import com.soft.service.IUserAddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户地址表  服务实现类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public ResponseResult getUserAddress(String userId) {
        if(StringUtils.isEmpty(userId)) {
            return ResponseResult.errorResult("参数传递错误");
        }
        List<UserAddress> userAddressList = userAddressMapper.selectList(Wrappers.lambdaQuery(UserAddress.class)
                .eq(UserAddress::getUserId, userId));
        return ResponseResult.successResult(userAddressList);
    }

    @Override
    public ResponseResult addUserAddress(UserAddressVO userAddressVO) {
        if(StringUtils.isEmpty(userAddressVO.getMobile().trim())) {
            return ResponseResult.errorResult("手机号不能为空");
        }
        userAddressVO.setId(Sid.nextShort());
        userAddressVO.setIsDefault(Constants.RequestConstants.NOT_IS_DEFAULT);
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(userAddressVO, userAddress);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());
        userAddressMapper.insert(userAddress);

        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult deleteUserAddress(String id) {
        if(StringUtils.isEmpty(id)) {
            return ResponseResult.errorResult("参数错误");
        }
        userAddressMapper.deleteById(id);
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult updateUserAddress(UserAddressVO userAddressVO) {
        if(StringUtils.isEmpty(userAddressVO.getId())) {
            return ResponseResult.errorResult("参数错误");
        }
        if(StringUtils.isEmpty(userAddressVO.getMobile().trim())) {
            return ResponseResult.errorResult("手机号不能为空");
        }
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(userAddressVO,userAddress);
        userAddressMapper.updateById(userAddress);
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult setDefalutAddress(UserAddressVO userAddressVO) {
        if(StringUtils.isEmpty(userAddressVO.getUserId()) || StringUtils.isEmpty(userAddressVO.getId())) {
            return ResponseResult.errorResult("参数错误");
        }
        //将原来默认地址删除
        List<UserAddress> userAddressList = userAddressMapper.selectList(Wrappers.lambdaQuery(UserAddress.class)
                .eq(UserAddress::getUserId, userAddressVO.getUserId()));
        List<UserAddress> collect = userAddressList.stream().filter(x -> x.getIsDefault().equals(Constants.RequestConstants.IS_DEFAULT)).map(x -> {
            x.setIsDefault(Constants.RequestConstants.NOT_IS_DEFAULT);
            return x;
        }).collect(Collectors.toList());
        UserAddress userAddress = null;
        if(!CollectionUtils.isEmpty(collect)) {
            userAddress = collect.get(0);
            userAddressMapper.updateById(userAddress);
        }

        //设置新的默认地址
        List<UserAddress> addressList = userAddressList.stream().filter(x -> x.getId().equals(userAddressVO.getId())).map(x -> {
            x.setIsDefault(Constants.RequestConstants.IS_DEFAULT);
            return x;
        }).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(addressList)) {
            return ResponseResult.errorResult("参数错误");
        }
        userAddressMapper.updateById(addressList.get(0));
        return ResponseResult.successResult();
    }
}
