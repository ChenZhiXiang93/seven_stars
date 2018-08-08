package com.bonc.pojo;

/**
 * @ClassName UserLog
 * @Description 登录信息
 * @Author chenzhixiang
 * @Date 2018/8/810:26
 * @Version 1.0
 **/
public class UserLog {

    private Integer id;

    private String userName;

    private String loginTime;

    private String loginIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
