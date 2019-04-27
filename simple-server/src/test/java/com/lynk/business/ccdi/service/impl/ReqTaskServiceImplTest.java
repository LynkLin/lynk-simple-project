package com.lynk.business.ccdi.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.service.IReqTaskService;
import com.lynk.system.exception.SystemException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @authory: Lynk
 * @date: 2019/04/23
 */
public class ReqTaskServiceImplTest extends BaseJunitTest {
    @Autowired
    private IReqTaskService reqTaskService;

    @Test
    public void downloadReqFile() throws SystemException {
        reqTaskService.downloadUnzipReqFile();
    }
}