package com.bonc.service;

import com.bonc.pojo.UserLog;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 16:06 2018/8/6
 * @Modified By:
 */
public interface UserService {

    Object getUserByName(String username);

    void saveUserInfo(UserLog user);
}
