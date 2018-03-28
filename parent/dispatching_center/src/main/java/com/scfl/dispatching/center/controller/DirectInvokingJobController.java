package com.scfl.dispatching.center.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.scfl.base.controller.BaseController;
import com.scfl.base.utils.Result;
import com.scfl.dispatching.center.config.invoke.Task.JobTestTask;
import com.scfl.dispatching.center.entity.JobRecord;
import com.scfl.dispatching.center.entity.OuterInvokingClass;
import com.scfl.dispatching.center.entity.OuterInvokingJar;
import com.scfl.dispatching.center.entity.OuterInvokingMethod;
import com.scfl.dispatching.center.service.JobRecordService;
import com.scfl.dispatching.center.service.OuterInvokingClassService;
import com.scfl.dispatching.center.service.OuterInvokingJarService;
import com.scfl.dispatching.center.service.OuterInvokingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.scfl.base.utils.CustomStringProcess.assignModuleIsNotExists;
/**
 * 及时手动调用作业
 * @author ylw
 * @date 18-3-23 下午2:01
 * @param
 * @return
 */
@RestController
@RequestMapping("/direct/job")
public class DirectInvokingJobController extends BaseController {
    private static final long serialVersionUID = 3621283868291133200L;

    @Autowired
    private OuterInvokingJarService outerInvokingJarService;
    @Autowired
    private OuterInvokingClassService outerInvokingClassService;
    @Autowired
    private OuterInvokingMethodService outerInvokingMethodService;
    @Autowired
    private JobRecordService jobRecordService;

    @GetMapping("/{jarName}/{packagePath}/{className}/{methodName}")
    public Result executeTestTask(@PathVariable String jarName,
                                  @PathVariable String packagePath,
                                  @PathVariable String className,
                                  @PathVariable String methodName) throws Exception{
        List<OuterInvokingJar> outerInvokingJarList =  outerInvokingJarService.selectList(new EntityWrapper<OuterInvokingJar>()
                .where("jar_name={0}",jarName));
        List<OuterInvokingClass> outerInvokingClassLsit = outerInvokingClassService.selectList(new EntityWrapper<OuterInvokingClass>()
                .where("package_path={0}",packagePath).and("class_name={0}",className));
        List<OuterInvokingMethod> outerInvokingMethodList = outerInvokingMethodService.selectList(new EntityWrapper<OuterInvokingMethod>()
                .where("method_name={0}",methodName));

        if(outerInvokingJarList == null || outerInvokingJarList.isEmpty()
                || outerInvokingClassLsit == null || outerInvokingClassLsit.isEmpty()
                || outerInvokingMethodList == null || outerInvokingMethodList.isEmpty()){
            return Result.FAIL(assignModuleIsNotExists("jar,类,方法"));
        }

        Thread testThread = new Thread(new JobTestTask(jobRecordService,jarName,className,methodName),"jobTestThread");
        testThread.start();
        testThread.join(1000);

        List<String> sort = new ArrayList<>();
        sort.add("create_time");
        sort.add("update_time");
        EntityWrapper<JobRecord> ew = new EntityWrapper<>();
        ew.where("full_class_name={0}",packagePath+"."+className)
                .and("method_name={0}",methodName).orderDesc(sort).last("limit 1");
        JobRecord jobRecord = jobRecordService.selectOne(ew);
        return Result.OK(jobRecord);
    }
}
