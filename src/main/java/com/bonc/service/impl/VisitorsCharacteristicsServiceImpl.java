package com.bonc.service.impl;

import com.bonc.mapper.VisitorsCharacteristicsMapper;
import com.bonc.response.ResponseData;
import com.bonc.service.VisitorsCharacteristicsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 15:17 2018/8/6
 * @Modified By:
 */
@Service
@Component
public class VisitorsCharacteristicsServiceImpl implements VisitorsCharacteristicsService {

    private Logger logger = LoggerFactory.getLogger(VisitorsCharacteristicsServiceImpl.class);

    @Autowired
    private VisitorsCharacteristicsMapper visitorsCharacteristicsMapper;

    @Override
    public Object getVisitorsBystatMon(String date) throws Exception {
        List res =  visitorsCharacteristicsMapper.getVisitorsBystatMon(date);
        return ResponseData.turnResponse(res);
    }
}
