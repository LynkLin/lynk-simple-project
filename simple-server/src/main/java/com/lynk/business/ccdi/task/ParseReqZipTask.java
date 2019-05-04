package com.lynk.business.ccdi.task;

import com.lynk.business.ccdi.file.service.IReqTaskService;
import com.lynk.system.exception.SystemException;
import com.lynk.system.task.BaseSystemJob;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 解析待处理的XML请求文件, 并插入数据库
 * @author Lynk @ 2019/04/28
 */
public class ParseReqZipTask extends BaseSystemJob {
    @Autowired
    private IReqTaskService reqTaskServiceImpl;

    @Override
    public void run() throws SystemException {
        reqTaskServiceImpl.parseReqZip();
    }
}
