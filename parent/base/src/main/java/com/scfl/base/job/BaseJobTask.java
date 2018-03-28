package com.scfl.base.job;
/**
 * 基础作业任务类
 * @author ylw
 * @date 18-3-23 下午4:32
 * @param
 * @return
 */
public class BaseJobTask {
    // 运行状态
    private boolean status = true;
    public void stop(){
        if(status){
            status=false;
        }
    }
}
