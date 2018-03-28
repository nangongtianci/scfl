package com.scfl.dispatching.center.service;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.Map;

/**
 * quartz 服务接口
 * @author ylw  
 * @date 18-3-22 下午3:28
 * @param   
 * @return   
 */ 
public interface JobService{
    // 分页查询
    Page<Map> selectJobAndTriggerDetailsPage(Page<Map> page);
}
