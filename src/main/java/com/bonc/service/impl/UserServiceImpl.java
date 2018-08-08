package com.bonc.service.impl;

import com.bonc.mapper.UserMapper;
import com.bonc.pojo.UserLog;
import com.bonc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 16:07 2018/8/6
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Object getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void saveUserInfo(UserLog user) {
        userMapper.saveUserInfo(user);
    }
}
