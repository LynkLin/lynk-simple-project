package com.lynk.system.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lynk.system.common.Constants;
import com.lynk.system.dao.SysTaskDao;
import com.lynk.system.entity.SysTask;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.tool.AppManager;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @author Lynk
 */
public class SysTaskManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysTaskManager.class);

    private Scheduler scheduler;

    private static SysTaskManager sysTaskManager;

    public static SysTaskManager getInstance() {
        if (sysTaskManager == null) {
            sysTaskManager = new SysTaskManager();
        }
        return sysTaskManager;
    }

    private SysTaskManager() {
    }

    public void init(Scheduler scheduler) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("start init task SysTaskManager");
        }

        this.scheduler = scheduler;
        try {
            scheduler.clear();
        } catch (SchedulerException e) {
            LOGGER.error("clear scheduler error", e);
        }

        SysTaskDao sysTaskDao = AppManager.getBean("sysTaskDao", SysTaskDao.class);

        List<SysTask> tasks = sysTaskDao.selectList(new QueryWrapper<SysTask>().eq(SysTask.IS_ENABLE, true));
        for (SysTask task: tasks) {
            addTask(task);
        }

        try {
            scheduler.start();
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("system tasks starts......");
            }
        } catch (SchedulerException e) {
            LOGGER.error("start scheduler error", e);
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("init task SysTaskManager finished");
        }
    }

    /**
     * add task to scheduler
     * @param task
     */
    public void addTask(SysTask task) throws SystemException {
        try {
            Class jobClass = Class.forName(task.getClassName());
            Object jobObj = jobClass.newInstance();
            if (jobObj instanceof BaseSystemJob) {
                Class<? extends BaseSystemJob> systemJobClass = ((BaseSystemJob) jobObj).getClass();
                JobDetail jobDetail = JobBuilder.newJob(systemJobClass)
                        .withIdentity(getJobKey(task))
                        .withDescription(task.getRemark())
                        .build();
                jobDetail.getJobDataMap().put(Constants.JOB_DATA_MAP_KEY, task.getId());

                Trigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity(getTriggerKey(task))
                        .withDescription(task.getRemark())
                        .withSchedule(CronScheduleBuilder.cronSchedule(task.getCronExpression()).withMisfireHandlingInstructionDoNothing())
                        .build();
                scheduler.scheduleJob(jobDetail, trigger);
                if (task.getPause()) {
                    pauseTask(task);
                }
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("add task success, task id: {}", task.getId());
                }
            } else {
                LOGGER.error("add task {} error: class not a BaseSystemJob", task.getCode());
                throw new SystemException(ErrorCode.SYS019, task.getCode());
            }
        } catch (Exception e) {
            LOGGER.error("add task {} error: {}", task.getCode(), e.getMessage());
            throw new SystemException(ErrorCode.SYS019, task.getCode());
        }
    }

    /**
     * update task trigger
     * @param task
     */
    public void updateTask(SysTask task) throws SystemException {
        try {
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(getTriggerKey(task))
                    .withDescription(task.getRemark())
                    .withSchedule(CronScheduleBuilder.cronSchedule(task.getCronExpression()).withMisfireHandlingInstructionDoNothing())
                    .build();
            scheduler.rescheduleJob(getTriggerKey(task), trigger);
        } catch (SchedulerException e) {
            LOGGER.error("update task {} error: {}", task.getCode(), e.getMessage());
        }
    }

    /**
     * remove task
     * @param task
     */
    public void removeTask(SysTask task) throws SystemException {
        try {
            scheduler.deleteJob(getJobKey(task));
        } catch (SchedulerException e) {
            LOGGER.error("remove task {} error: {}", task.getCode(), e.getMessage());
            throw new SystemException(ErrorCode.SYS018, task.getCode());
        }
    }

    /**
     * run the task immediately
     * @param task
     */
    public void runTask(SysTask task) throws SystemException {
        try {
            scheduler.triggerJob(getJobKey(task));
        } catch (SchedulerException e) {
            LOGGER.error("run task {} error", task.getCode());
            throw new SystemException(ErrorCode.SYS011, task.getCode());
        }
    }

    /**
     * pause task
     * @param task
     */
    public void pauseTask(SysTask task) throws SystemException {
        try {
            scheduler.pauseJob(getJobKey(task));
        } catch (SchedulerException e) {
            LOGGER.error("pause task {} error: {}", task.getCode(), e.getMessage());
            throw new SystemException(ErrorCode.SYS012, task.getCode());
        }
    }

    /**
     * resume paused task
     * @param task
     */
    public void resumeTask(SysTask task) throws SystemException {
        try {
            scheduler.resumeJob(getJobKey(task));
        } catch (SchedulerException e) {
            LOGGER.error("resume task {} error: {}", task.getCode(), e.getMessage());
            throw new SystemException(ErrorCode.SYS013, task.getCode());
        }
    }

    private JobKey getJobKey(SysTask task) {
        return new JobKey(task.getId(), task.getCategory());
    }

    private TriggerKey getTriggerKey(SysTask task) {
        return new TriggerKey(task.getId(), task.getCategory());
    }
}