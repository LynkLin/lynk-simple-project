package com.lynk.business.ccdi.service;

import com.lynk.system.exception.SystemException;

/**
 * @authory: Lynk
 * @date: 2019/04/23
 */
public interface IReqTaskService {
    /**
     * 下载FTP上的请求包
     * @throws SystemException
     */
    void downloadReqFile() throws SystemException;
}
