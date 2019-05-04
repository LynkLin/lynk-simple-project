package com.lynk.system.task;

import com.lynk.system.common.Constant;
import com.lynk.system.exception.SystemException;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Every task must extends this class.
 * @author Lynk on 2017/4/11.
 */
public abstract class BaseSystemJob extends QuartzJobBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSystemJob.class);

    @Override
    public void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String taskId = jobDataMap.getString(Constant.JOB_DATA_MAP_KEY);

        LOGGER.info("==========SYSTEM JOB RUN START [{}]{}==========", taskId, getClass().getSimpleName());

        try {
            run();
        } catch (SystemException e) {
            LOGGER.error("==========SYSTEM JOB RUN ERROR==========", e);
            throw new JobExecutionException(e);
        }
        LOGGER.info("==========SYSTEM JOB RUN END [{}]{}==========", taskId, getClass().getSimpleName());
    }

    /**
     * JOB RUN BODY
     * @throws SystemException
     */
    public abstract void run() throws SystemException;
}