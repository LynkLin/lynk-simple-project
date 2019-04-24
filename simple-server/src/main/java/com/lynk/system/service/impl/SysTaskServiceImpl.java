package com.lynk.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lynk.system.common.DBUtil;
import com.lynk.system.common.ValidateUtil;
import com.lynk.system.entity.SysTask;
import com.lynk.system.dao.SysTaskDao;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.service.ISysTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lynk.system.task.SysTaskManager;
import com.lynk.system.web.request.SysTaskAddRequest;
import com.lynk.system.web.request.SysTaskGetRequest;
import com.lynk.system.web.request.SysTaskUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lynk
 * @since 2019-04-13
 */
@Service
public class SysTaskServiceImpl extends ServiceImpl<SysTaskDao, SysTask> implements ISysTaskService {

    @Override
    @Transactional(rollbackFor = SystemException.class)
    public String add(SysTaskAddRequest sysTaskAddRequest) throws SystemException {
        String code = sysTaskAddRequest.getCode();
        if (ValidateUtil.isEmpty(code)) {
            throw new SystemException(ErrorCode.SYS010, "code");
        }
        String name = sysTaskAddRequest.getName();
        if (ValidateUtil.isEmpty(code)) {
            throw new SystemException(ErrorCode.SYS010, "name");
        }
        String category = sysTaskAddRequest.getCategory();
        if (ValidateUtil.isEmpty(code)) {
            throw new SystemException(ErrorCode.SYS010, "category");
        }
        String className = sysTaskAddRequest.getClassName();
        if (ValidateUtil.isEmpty(code)) {
            throw new SystemException(ErrorCode.SYS010, "className");
        }
        String cronExpression = sysTaskAddRequest.getCronExpression();
        if (ValidateUtil.isEmpty(code)) {
            throw new SystemException(ErrorCode.SYS010, "cronExpression");
        }
        Integer sequence = sysTaskAddRequest.getSequence();
        if (ValidateUtil.isEmpty(sequence)) {
            sequence = 0;
        }

        //code must be unique
        if (taskCodeExists(code, null)) {
            throw new SystemException(ErrorCode.SYS007, code);
        }

        SysTask task = new SysTask();
        task.setCode(code);
        task.setName(name);
        task.setCategory(category);
        task.setClassName(className);
        task.setCronExpression(cronExpression);
        task.setSequence(sequence);
        task.setRun(false);
        task.setPause(false);
        task.setEnable(true);
        task.setRemark(sysTaskAddRequest.getRemark());

        int result = baseMapper.insert(task);
        if (!retBool(result)) {
            throw new SystemException(ErrorCode.SYS004);
        }

        //add task to quartz
        SysTaskManager.getInstance().addTask(task);

        return task.getId();
    }

    @Override
    @Transactional(rollbackFor = SystemException.class)
    public void update(SysTaskUpdateRequest sysTaskUpdateRequest) throws SystemException {
        SysTask taskDb = baseMapper.selectById(sysTaskUpdateRequest.getId());

        Integer operator = sysTaskUpdateRequest.getOperator();
        SysTask task = new SysTask();
        task.setId(taskDb.getId());
        switch (operator) {
            case SysTaskUpdateRequest.OPERATOR_UPDATE_CRON_EXPRESSION:
                String cronExpression = sysTaskUpdateRequest.getCronExpression();
                if (ValidateUtil.isEmpty(cronExpression)) {
                    throw new SystemException(ErrorCode.SYS010, "cronExpression");
                }
                task.setCronExpression(cronExpression);
                baseMapper.updateById(task);

                taskDb.setCronExpression(cronExpression);
                SysTaskManager.getInstance().updateTask(taskDb);
                break;
            case SysTaskUpdateRequest.OPERATOR_DISABLE_TASK:
                if (!taskDb.getEnable()) {
                    throw new SystemException(ErrorCode.SYS021, taskDb.getId());
                }
                task.setEnable(false);
                baseMapper.updateById(task);

                SysTaskManager.getInstance().removeTask(taskDb);
                break;
            case SysTaskUpdateRequest.OPERATOR_ENABLE_TASK:
                if (taskDb.getEnable()) {
                    throw new SystemException(ErrorCode.SYS022, taskDb.getId());
                }
                task.setEnable(true);
                baseMapper.updateById(task);

                SysTaskManager.getInstance().addTask(taskDb);
                break;
            case SysTaskUpdateRequest.OPERATOR_PAUSE_TASK:
                if (!taskDb.getRun()) {
                    throw new SystemException(ErrorCode.SYS015, taskDb.getId());
                }
                if (taskDb.getPause()) {
                    throw new SystemException(ErrorCode.SYS016, taskDb.getId());
                }
                task.setPause(true);
                baseMapper.updateById(task);

                SysTaskManager.getInstance().pauseTask(taskDb);
                break;
            case SysTaskUpdateRequest.OPERATOR_RESUME_TASK:
                if (!taskDb.getPause()) {
                    throw new SystemException(ErrorCode.SYS017, taskDb.getId());
                }
                task.setPause(false);
                baseMapper.updateById(task);

                SysTaskManager.getInstance().resumeTask(taskDb);
                break;
            case SysTaskUpdateRequest.OPERATOR_RUN_TASK:
                if (taskDb.getRun()) {
                    throw new SystemException(ErrorCode.SYS014, taskDb.getId());
                }
                SysTaskManager.getInstance().runTask(taskDb);
                break;
            default:
                throw new SystemException(ErrorCode.SYS023, "operator");
        }
    }

    @Override
    @Transactional(rollbackFor = SystemException.class)
    public void delete(String id) throws SystemException {
        SysTask task = getById(id);
        if (task.getEnable()) {
            SysTaskManager.getInstance().removeTask(task);
        }
        baseMapper.deleteById(id);
    }

    @Override
    public IPage<SysTask> get(SysTaskGetRequest sysTaskGetRequest) throws SystemException {
        IPage<SysTask> page = new Page<>(sysTaskGetRequest.getPage(), sysTaskGetRequest.getPerPage());
        QueryWrapper<SysTask> entityWrapper = new QueryWrapper<>();

        String code = sysTaskGetRequest.getCode();
        if (ValidateUtil.isNotEmpty(code)) {
            entityWrapper.like(SysTask.CODE, DBUtil.middleLikeFormat(code));
        }

        String name = sysTaskGetRequest.getName();
        if (ValidateUtil.isNotEmpty(name)) {
            entityWrapper.like(SysTask.NAME, DBUtil.middleLikeFormat(name));
        }

        String group = sysTaskGetRequest.getCategory();
        if (ValidateUtil.isNotEmpty(group)) {
            entityWrapper.like(SysTask.CATEGORY, DBUtil.middleLikeFormat(group));
        }

        String className = sysTaskGetRequest.getClassName();
        if (ValidateUtil.isNotEmpty(className)) {
            entityWrapper.like(SysTask.CLASS_NAME, DBUtil.middleLikeFormat(className));
        }

        Boolean run = sysTaskGetRequest.getRun();
        if (ValidateUtil.isNotEmpty(run)) {
            entityWrapper.eq(SysTask.IS_RUN, run);
        }

        Boolean pause = sysTaskGetRequest.getPause();
        if (ValidateUtil.isNotEmpty(pause)) {
            entityWrapper.eq(SysTask.IS_PAUSE, pause);
        }

        Boolean enable = sysTaskGetRequest.getEnable();
        if (ValidateUtil.isNotEmpty(enable)) {
            entityWrapper.eq(SysTask.IS_ENABLE, enable);
        }

        entityWrapper.orderByAsc(SysTask.SEQUENCE);

        return baseMapper.selectPage(page, entityWrapper);
    }

    @Override
    public SysTask getById(String id) throws SystemException {
        return baseMapper.selectById(id);
    }

    @Override
    public void run(String id) throws SystemException {
        SysTask task = baseMapper.selectById(id);
        if (task.getRun()) {
            throw new SystemException(ErrorCode.SYS014, task.getCode());
        }
        SysTaskManager.getInstance().runTask(task);
    }

    @Override
    public void pause(String id) throws SystemException {
        SysTask task = baseMapper.selectById(id);
        if (!task.getRun()) {
            throw new SystemException(ErrorCode.SYS015, task.getCode());
        }
        if (task.getPause()) {
            throw new SystemException(ErrorCode.SYS016, task.getCode());
        }
        SysTaskManager.getInstance().pauseTask(task);
    }

    @Override
    public void resume(String id) throws SystemException {
        SysTask task = baseMapper.selectById(id);
        if (!task.getPause()) {
            throw new SystemException(ErrorCode.SYS017, task.getCode());
        }
        SysTaskManager.getInstance().resumeTask(task);
    }

    /**
     * code must be unique
     * @param code
     * @param id
     * @return
     */
    private boolean taskCodeExists(String code, String id) {
        QueryWrapper<SysTask> entityWrapper = new QueryWrapper<>();
        entityWrapper.eq(SysTask.CODE, code);
        if (ValidateUtil.isNotEmpty(id)) {
            entityWrapper.ne(SysTask.ID, id);
        }
        int existsCount = count(entityWrapper);
        return existsCount > 0;
    }

}
