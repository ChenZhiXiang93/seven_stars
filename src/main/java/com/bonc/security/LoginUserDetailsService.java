package com.bonc.security;

import com.bonc.exception.BusinessException;
import com.bonc.pojo.User;
import com.bonc.response.CommResponseEnum;
import com.bonc.response.ResponseData;
import com.bonc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 16:13 2018/8/6
 * @Modified By:
 */
@Component
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userService.getUserByName(username);
        if (user == null || user.equals("")){
            throw new BusinessException(CommResponseEnum.USER2);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()),true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
