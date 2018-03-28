package com.scfl.dispatching.center.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.scfl.dispatching.center.mapper.JobMapper;
import com.scfl.dispatching.center.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    @Override
    public Page<Map> selectJobAndTriggerDetailsPage(Page<Map> page) {
        return page.setRecords(jobMapper.selectJobAndTriggerDetails(page));
    }
}
