package com.ajilisiwei.devplatform.controller;

import com.ajilisiwei.devplatform.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ajilisiwei.devplatform.pojo.*;
import com.ajilisiwei.devplatform.common.*;

import javax.servlet.http.HttpSession;

/**
 * Created by WEI on 12/08/2017.
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServiceImpl iUserService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response=iUserService.login(username,password);
        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }
}
