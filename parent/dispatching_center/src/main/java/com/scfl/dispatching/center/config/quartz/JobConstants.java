package com.scfl.dispatching.center.config.quartz;
/**
 * job常量类
 * @author ylw
 * @date 18-3-22 上午11:36
 * @param
 * @return
 */
public class JobConstants {
    /**
     * Job状态
     */
    public static class JobStatus{
        /**
         * 未处理
         */
        public static final String JOB_UNPROCESSED = "0";

        /**
         * 执行成功
         */
        public static final String JOB_SUCCESSED = "1";

        /**
         * 执行失败
         */
        public static final String JOB_FAILED = "-1";

        /**
         * 过期
         */
        public static final String JOB_EXPIRED = "-2";
    }

    /**
     * 任务组
     */
    public static final class JobGruop{

        /**
         * 默认的任务组
         */
        public static final String JOB_DEFAULT_GROUP_ = "job_default_group_id";

        /**
         * 默认的任务组
         */
        public static final String JOB_DEFAULT_GROUP_NAME = "job_default_group_name";
    }

    public static final class JobName{
        /**
         * 默认的任务名
         */
        public static final String JOB_DEFAULT_ID = "job_default_id";

        /**
         * 默认的任务名
         */
        public static final String JOB_DEFAULT_NAME = "job_default_name";
    }
}
