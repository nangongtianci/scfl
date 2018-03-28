package com.scfl.dispatching.center.service.impl;

import com.scfl.dispatching.center.entity.JobRecord;
import com.scfl.dispatching.center.mapper.JobRecordMapper;
import com.scfl.dispatching.center.service.JobRecordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 作业执行记录 服务实现类
 * </p>
 *
 * @author ylw
 * @since 2018-03-23
 */
@Service
public class JobRecordServiceImpl extends ServiceImpl<JobRecordMapper, JobRecord> implements JobRecordService {

}
