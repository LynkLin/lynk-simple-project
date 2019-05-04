package com.lynk.business.ccdi.task;

import com.lynk.business.ccdi.file.service.IReqTaskService;
import com.lynk.system.exception.SystemException;
import com.lynk.system.task.BaseSystemJob;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 从FTP下载文件, 解压缩, 并将数据插入表中
 * @author Lynk @ 2019/04/22
 */
public class DownloadUnzipReqTask extends BaseSystemJob {
    @Autowired
    private IReqTaskService reqTaskServiceImpl;

    @Override
    public void run() throws SystemException {
        reqTaskServiceImpl.downloadUnzipReqFile();
    }
}
