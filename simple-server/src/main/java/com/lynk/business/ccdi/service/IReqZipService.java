package com.lynk.business.ccdi.service;

import com.lynk.business.ccdi.entity.ReqZip;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lynk.system.exception.SystemException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lynk
 * @since 2019-04-18
 */
public interface IReqZipService extends IService<ReqZip> {

    /**
     * 下载FTP上的请求包
     * @throws SystemException
     */
    void downloadReqFile() throws SystemException;
}
