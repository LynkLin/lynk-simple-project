package com.lynk.business.ccdi.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.service.IReqZipService;
import com.lynk.system.exception.SystemException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @authory: Lynk
 * @date: 2019/04/22
 */
public class ReqZipServiceImplTest extends BaseJunitTest {

    @Autowired
    private IReqZipService reqZipServiceImpl;

    @Test
    public void downloadReqFile() throws SystemException {
        reqZipServiceImpl.downloadReqFile();
    }
}