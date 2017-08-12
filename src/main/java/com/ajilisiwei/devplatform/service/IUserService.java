package com.ajilisiwei.devplatform.service;
import com.ajilisiwei.devplatform.pojo.*;
import com.ajilisiwei.devplatform.common.*;

/**
 * Created by WEI on 12/08/2017.
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);
}
