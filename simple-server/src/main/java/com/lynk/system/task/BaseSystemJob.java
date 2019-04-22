package com.lynk.system.task;

import com.lynk.system.common.Constant;
import com.lynk.system.dao.SysTaskDao;
import com.lynk.system.entity.SysTask;
import com.lynk.system.exception.SystemException;
import com.lynk.system.tool.AppManager;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Every task must extends this class.
 * @author Lynk on 2017/4/11.
 */
public abstract class BaseSystemJob implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSystemJob.class);

    @Autowired
    private SysTaskDao sysTaskDao;

    public BaseSystemJob() {
        sysTaskDao = (SysTaskDao) AppManager.getBean("sysTaskDao");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String taskId = jobDataMap.getString(Constant.JOB_DATA_MAP_KEY);

        SysTask task = new SysTask();
        task.setId(taskId);

        LOGGER.info("==========SYSTEM JOB RUN START [{}]==========", taskId, getClass().getSimpleName());

        try {
            task.setRun(true);
            sysTaskDao.updateById(task);
            run();
        } catch (SystemException e) {
            LOGGER.error("==========SYSTEM JOB RUN ERROR==========", e);
            throw new JobExecutionException(e);
        } finally {
            task.setRun(false);
            sysTaskDao.updateById(task);
        }
        LOGGER.info("==========SYSTEM JOB RUN END [{}]{}==========", taskId, getClass().getSimpleName());
    }

    /**
     * JOB RUN BODY
     * @throws SystemException
     */
    public abstract void run() throws SystemException;
}