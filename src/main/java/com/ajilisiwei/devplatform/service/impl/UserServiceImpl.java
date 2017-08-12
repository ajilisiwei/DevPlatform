package com.ajilisiwei.devplatform.service.impl;

import com.ajilisiwei.devplatform.common.ServerResponse;
import com.ajilisiwei.devplatform.pojo.User;
import com.ajilisiwei.devplatform.service.IUserService;
import com.ajilisiwei.devplatform.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.ajilisiwei.devplatform.dao.UserMapper;
import org.springframework.stereotype.Service;

/**
 * Created by WEI on 12/08/2017.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount=userMapper.checkUsername(username);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        System.out.println(username);
        String md5Password= MD5Util.MD5EncodeUtf8(password);
        System.out.println(md5Password);
        User user=userMapper.selectLongin(username,md5Password);
        if(user==null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        System.out.println(user);
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",user);
    }
}
