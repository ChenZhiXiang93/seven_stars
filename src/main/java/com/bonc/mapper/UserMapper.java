package com.bonc.mapper;

import com.bonc.pojo.User;
import com.bonc.pojo.UserLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 15:58 2018/8/6
 * @Modified By:
 */
public interface UserMapper {

    /**查询用户  @Select("select * from czx.T_PEOPLE_INFO where card =#{card}")*/
    @Select("select username,password from czx.BUS_CIR_USER_INFO where username = #{username}")
    User getUserByName(String username);

    /**登录日志*/
    @Insert("insert into czx.BUS_CIR_USER_LOG values(#{userName},#{loginTime},#{loginIp})")
    void saveUserInfo(UserLog user);
}
