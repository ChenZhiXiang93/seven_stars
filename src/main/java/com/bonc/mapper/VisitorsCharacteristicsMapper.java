package com.bonc.mapper;

import com.bonc.pojo.VisitorsCharacteristics;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 15:08 2018/8/6
 * @Modified By:
 */
public interface VisitorsCharacteristicsMapper {
    /**访客统计  男  女  未知  年龄*/
    @Select("select SEX_M_NUM as sexMNum,SEX_F_NUM as sexFNum,SEX_N_NUM as sexNNum," +
            "AGE_50_NUM as age50Num,AGE_60_NUM as age60Num,AGE_70_NUM as age70Num," +
            "AGE_80_NUM as age80Num,AGE_90_NUM as age90Num,AGE_00_NUM as age00Num from " +
            "czx.BUS_CIR_BASE_INFO_MON where STAT_MON = #{date}")
    List<VisitorsCharacteristics> getVisitorsBystatMon(String date);


}
