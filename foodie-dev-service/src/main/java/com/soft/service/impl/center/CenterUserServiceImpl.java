package com.soft.service.impl.center;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.common.CookieUtils;
import com.soft.common.ResponseResult;
import com.soft.mapper.UserAddressMapper;
import com.soft.mapper.center.CenterUserMapper;
import com.soft.pojo.UserAddress;
import com.soft.pojo.Users;
import com.soft.pojo.VO.UserVO;
import com.soft.service.center.CenterUserService;
import com.soft.utils.FileUtils;
import com.soft.utils.OSSUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-17:05
 * @Description: 用户中心业务
 */
@Service
public class CenterUserServiceImpl extends ServiceImpl<CenterUserMapper, Users> implements CenterUserService {

    @Resource
    private CenterUserMapper centerUserMapper;
    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public ResponseResult userInfo(String userId) {
        if(StringUtils.isBlank(userId)) {
            return ResponseResult.errorResult("参数错误");
        }
        Users users = centerUserMapper.selectById(userId);

        return ResponseResult.successResult(users);
    }

    @Override
    public ResponseResult findUserAddress(String userId) {
        if(StringUtils.isBlank(userId)) {
            return ResponseResult.errorResult("参数错误");
        }
        List<UserAddress> userAddresses = userAddressMapper.selectList(Wrappers.lambdaQuery(new UserAddress()).eq(UserAddress::getUserId, userId));

        return ResponseResult.successResult(userAddresses);
    }

    @Override
    public ResponseResult upsert(UserVO userVO, HttpServletRequest request, HttpServletResponse response) {
        Users users1 = new Users();
        BeanUtils.copyProperties(userVO, users1);
        if(StringUtils.isBlank(userVO.getId())) {
            //新增
            centerUserMapper.insert(users1);
        } else {
            Users users = centerUserMapper.selectById(userVO.getId());
            if(Objects.nonNull(users)) {
                centerUserMapper.updateById(users1);
                //修改用户信息后，删除token中的用户信息，进行重新登录
                CookieUtils.setCookie(request, response, "user", users1.toString());
            }
        }

        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult upload(MultipartFile file) {
        //MultipartFile 转化为File
        File file1 = FileUtils.multipartFile2File(file);
        //上传到oss
        String filePath = OSSUtil.upload(file1);
        return ResponseResult.successResult(filePath);
    }
}
