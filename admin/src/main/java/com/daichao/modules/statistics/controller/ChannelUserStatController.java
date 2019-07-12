package com.daichao.modules.statistics.controller;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.modules.statistics.entity.ChannelStatEntity;
import com.daichao.modules.statistics.entity.UserStatEntity;
import com.daichao.modules.statistics.service.ChannelStatService;
import com.daichao.modules.sys.controller.AbstractController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat")
public class ChannelUserStatController extends AbstractController {

    @Autowired
    private ChannelStatService channelStatService;

    @RequestMapping("/getChannelStatlist")
    public Page<ChannelStatEntity> getChannelStatlist(@RequestBody Map<String, Object> params) {
        String dateRange = "";
        String channelName = "";
        if(null != params.get("dateRange")) {
        	dateRange =params.get("dateRange").toString();
        }
        if(null != params.get("channelName")) {
        	channelName = params.get("channelName").toString();
        }
        if (StringUtils.isNotBlank(dateRange)) {
            String[] dates = dateRange.split(" - ");
            params.put("startDate", dates[0]);
            params.put("endDate", dates[1]);
        }
        params.put("channelName", channelName);
        return channelStatService.getChannelStatList(params);
    }
    
    @RequestMapping("/getUserStatlist")
    public Page<UserStatEntity> getUserStatlist(@RequestBody Map<String, Object> params) {
    	String dateRange = "";
        String channelName = "";
        if(null != params.get("dateRange")) {
        	dateRange =params.get("dateRange").toString();
        }
        if(null != params.get("channelName")) {
        	channelName = params.get("channelName").toString();
        }
	    if (StringUtils.isNotBlank(dateRange)) {
	        String[] dates = dateRange.split(" - ");
	        params.put("startDate", dates[0]);
	        params.put("endDate", dates[1]);
	    }
        params.put("channelName", channelName);
        return channelStatService.getUserStatList(params);
    }

}
