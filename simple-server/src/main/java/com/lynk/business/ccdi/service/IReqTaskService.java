package com.lynk.business.ccdi.service;

import com.lynk.system.exception.SystemException;

/**
 * @author Lynk @ 2019/04/23
 */
public interface IReqTaskService {
    /**
     * 下载解压缩FTP上的请求包
     * @throws SystemException
     */
    void downloadUnzipReqFile() throws SystemException;

    /**
     * 解析请求文件
     * @throws SystemException
     */
    void parseReqZip() throws SystemException;
}
