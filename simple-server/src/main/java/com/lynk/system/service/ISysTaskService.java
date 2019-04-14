package com.lynk.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lynk.system.entity.SysTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lynk.system.exception.SystemException;
import com.lynk.system.web.request.SysTaskAddRequest;
import com.lynk.system.web.request.SysTaskGetRequest;
import com.lynk.system.web.request.SysTaskUpdateRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lynk
 * @since 2019-04-13
 */
public interface ISysTaskService extends IService<SysTask> {
	/**
	 * add new task
	 * @param sysTaskAddRequest
	 * @return task id
	 * @throws SystemException
	 */
	String add(SysTaskAddRequest sysTaskAddRequest) throws SystemException;

	/**
	 * update task info </br>
	 * modify enable field will also add/remove task in quartz </br>
	 * modify pause field will also pause/stop task in quartz
	 * @param sysTaskUpdateRequest
	 * @throws SystemException
	 */
	void update(SysTaskUpdateRequest sysTaskUpdateRequest) throws SystemException;

	/**
	 * delete task by id
	 * @param id
	 * @throws SystemException
	 */
	void delete(String id) throws SystemException;

	/**
	 * get by request
	 * @param sysTaskGetRequest
	 * @return page info
	 * @throws SystemException
	 */
	IPage<SysTask> get(SysTaskGetRequest sysTaskGetRequest) throws SystemException;

	/**
	 * get by ID
	 * @param id
	 * @return task bean
	 * @throws SystemException
	 */
	SysTask getById(String id) throws SystemException;

	/**
	 * run task by id
	 * @param id
	 * @throws SystemException
	 */
	void run(String id) throws SystemException;

	/**
	 * pause task by id
	 * @param id
	 * @throws SystemException
	 */
	void pause(String id) throws SystemException;

	/**
	 * resume paused task by id
	 * @param id
	 * @throws SystemException
	 */
	void resume(String id ) throws SystemException;
}
