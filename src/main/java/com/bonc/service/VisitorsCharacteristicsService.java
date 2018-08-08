package com.bonc.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 15:15 2018/8/6
 * @Modified By:
 */
public interface VisitorsCharacteristicsService {

    Object getVisitorsBystatMon(@Param("date") String date) throws Exception;
}
