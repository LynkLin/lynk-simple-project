package com.lynk.business.ccdi.task;

import com.lynk.business.ccdi.service.IReqZipService;
import com.lynk.system.exception.SystemException;
import com.lynk.system.task.BaseSystemJob;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lynk @ 2019/04/22
 */
public class DownloadReqTask extends BaseSystemJob {
    @Autowired
    private IReqZipService reqZipServiceImpl;

    @Override
    public void run() throws SystemException {
        reqZipServiceImpl.downloadReqFile();
    }
}
