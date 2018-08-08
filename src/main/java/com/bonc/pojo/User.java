package com.bonc.pojo;

import java.io.Serializable;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 16:02 2018/8/6
 * @Modified By:
 */
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
