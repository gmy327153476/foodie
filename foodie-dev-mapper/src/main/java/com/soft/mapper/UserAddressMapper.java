package com.soft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户地址表  Mapper 接口
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress> {

}
