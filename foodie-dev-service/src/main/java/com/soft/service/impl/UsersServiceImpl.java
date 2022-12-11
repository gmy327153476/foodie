package com.soft.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.common.*;
import com.soft.enums.Sex;
import com.soft.mapper.UsersMapper;
import com.soft.pojo.VO.UserParamVO;
import com.soft.pojo.Users;
import com.soft.service.IUsersService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    private static final String USER_FACE = "https://foodie-bucket-beijing.oss-cn-beijing.aliyuncs.com/foodie/upload/1629768482%281%29.jpg";

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public List<Users> findUsers() {
        return usersMapper.selectList(Wrappers.lambdaQuery(Users.class));
    }

    @Override
    public ResponseResult verifyUsername(String username) {
        Users users = usersMapper.selectOne(Wrappers.lambdaQuery(Users.class).eq(Users::getUsername, username));

        if(!StringUtils.isEmpty(users)) {
            return ResponseResult.errorResult(BaseCode.USERNAME_EXIST);
        }
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult registerUser(HttpServletRequest request, HttpServletResponse response, UserParamVO userParamVO) {
        if(!userParamVO.getPassword().equals(userParamVO.getConfirmPassword())) {
            return ResponseResult.errorResult("两次密码输入不一致，请重新输入");
        }

        Users user = new Users();
        user.setId(Sid.nextShort());
        user.setUsername(userParamVO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userParamVO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setNickname(userParamVO.getUsername());
        user.setFace(USER_FACE);
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user));
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult login(HttpServletRequest request, HttpServletResponse response, UserParamVO userBO) {
        List<Users> usersList = null;
        try {
             usersList = usersMapper.selectList(Wrappers.lambdaQuery(Users.class)
                    .eq(Users::getUsername, userBO.getUsername())
                    .eq(Users::getPassword, MD5Utils.getMD5Str(userBO.getPassword())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(CollectionUtils.isEmpty(usersList)) {
            return ResponseResult.errorResult("用户名或密码不正确，请重新输入");
        }
        Users users = usersList.get(0);
        com.soft.pojo.VO.UserVO userVO = new com.soft.pojo.VO.UserVO();
        BeanUtils.copyProperties(users, userVO);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userVO));
        return ResponseResult.successResult(userVO);
    }
}
