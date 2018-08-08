package com.bonc.security;

import com.bonc.pojo.UserLog;
import com.bonc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:ChenZhiXiang
 * @Description: 登录成功处理类
 * @Date:Created in 17:21 2018/8/6
 * @Modified By:
 */
@Component("loginSuccess")
public class LoginSuccess implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(LoginSuccess.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        System.out.println("登录成功!"+authentication.getName());
        this.saveLoginInfo(request,authentication);
        redirectStrategy.sendRedirect(request,response,"/static/index.html");
    }
    /**
     *@Author chenzhixiang
     *@Description 登录成功后用户信息处理
     *@Date 12:23 2018/8/8
     *@Param
     *@return
    **/
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED,rollbackFor={Exception.class})
    public void saveLoginInfo(HttpServletRequest request,Authentication authentication){
        try {
            UserLog user = new UserLog();
            user.setUserName(authentication.getName());
            String ip = this.getIpAddress(request);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setLoginTime(sdf.format(date));
            user.setLoginIp(ip);
            this.userService.saveUserInfo(user);
        } catch (DataAccessException e) {
            if(logger.isWarnEnabled()){
                logger.info("无法更新用户登录信息至数据库");
            }
        }
    }

/**
 *@Author chenzhixiang
 *@Description 获取ip
 *@Date 12:22 2018/8/8
 *@Param
 *@return
**/
    public String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
