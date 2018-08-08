package com.bonc.controller;

import com.bonc.service.VisitorsCharacteristicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 14:27 2018/8/6
 * @Modified By:
 */
@RestController
public class VisitorsCharacteristicsController {

    @Autowired
    private VisitorsCharacteristicsService visitorsCharacteristicsService;

    @CrossOrigin
    @RequestMapping(value = "/VisitorsCharacteristics")
    public Object getVisitorsCharacteristicsByDate(@RequestParam(value = "date",required = false) String date) throws Exception {
        return visitorsCharacteristicsService.getVisitorsBystatMon(date);
    }


}
