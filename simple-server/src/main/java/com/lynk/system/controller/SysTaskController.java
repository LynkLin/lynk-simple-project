package com.lynk.system.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.lynk.system.entity.SysTask;
import com.lynk.system.exception.SystemException;
import com.lynk.system.log.annotation.SystemLog;
import com.lynk.system.security.annotation.RequirePermissions;
import com.lynk.system.service.ISysTaskService;
import com.lynk.system.web.base.PageResponse;
import com.lynk.system.web.base.Response;
import com.lynk.system.web.base.ResponseFactory;
import com.lynk.system.web.request.SysTaskAddRequest;
import com.lynk.system.web.request.SysTaskGetRequest;
import com.lynk.system.web.request.SysTaskUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lynk
 * @since 2017-10-17
 */
@RestController
@Api(value = "system task", description = "task manage")
@RequestMapping("v1/system/task")
@RequirePermissions(id = "TASK_GROUP", name = "Task Group")
public class SysTaskController {
	@Autowired
    private ISysTaskService sysTaskServiceImpl;

    @ApiOperation("create task")
    @PostMapping(value="/")
    @SystemLog(description = "create task")
    @RequirePermissions(id = "NEW_TASK", value = "/system/task:POST", name = "create task")
    public Response add(SysTaskAddRequest sysTaskAddRequest) {
        try {
            String id = sysTaskServiceImpl.add(sysTaskAddRequest);
            SysTask task = sysTaskServiceImpl.getById(id);
            return ResponseFactory.createSuccessResponse(task);
        } catch (SystemException e) {
            return ResponseFactory.createFailResponse(e);
        }
    }

    @ApiOperation("modify task")
    @PutMapping(value="/")
    @SystemLog(description = "modify task")
    @RequirePermissions(id = "MOD_TASK", value = "/system/task:PUT", name = "modify task")
    public Response update(SysTaskUpdateRequest sysTaskUpdateRequest) {
        try {
            sysTaskServiceImpl.update(sysTaskUpdateRequest);
            SysTask task = sysTaskServiceImpl.getById(sysTaskUpdateRequest.getId());
            return ResponseFactory.createSuccessResponse(task);
        } catch (SystemException e) {
            return ResponseFactory.createFailResponse(e);
        }
    }

    @ApiOperation("search tasks")
    @GetMapping(value="/")
    @SystemLog(description = "search tasks")
    @RequirePermissions(id = "GET_TASKS", value = "/system/task:GET", name = "search tasks")
    public PageResponse get(SysTaskGetRequest sysTaskGetRequest) {
        try {
            Page<SysTask> page = sysTaskServiceImpl.get(sysTaskGetRequest);
            return ResponseFactory.createPageResponse(page);
        } catch (SystemException e) {
            return ResponseFactory.createFailPageResponse(e);
        }
    }

    @ApiOperation("get task info by id")
    @GetMapping("/{id}")
    @SystemLog(description = "get task info by id")
    @RequirePermissions(id = "GET_TASK", value = "/system/task/{id}:GET", name = "get task info by id")
    public Response get(@PathVariable String id) {
        try {
            SysTask task = sysTaskServiceImpl.getById(id);
            return ResponseFactory.createSuccessResponse(task);
        } catch (SystemException e) {
            return ResponseFactory.createFailPageResponse(e);
        }
    }
}
