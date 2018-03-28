package com.scfl.dispatching.center.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.util.List;
import java.util.Map;

/**
 * quartz
 * @author ylw
 * @date 18-3-22 下午3:15
 * @param
 * @return
 */
public interface JobMapper extends BaseMapper{
    // 查询任务和调度器列表
    List<Map> selectJobAndTriggerDetails(Pagination page);
}
