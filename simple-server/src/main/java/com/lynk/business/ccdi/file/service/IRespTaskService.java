package com.lynk.business.ccdi.file.service;

import com.lynk.system.exception.SystemException;

/**
 * @author Lynk @ 2019-05-02 21:38
 */
public interface IRespTaskService {
    /**
     * 反馈RR28回执
     * @throws SystemException
     */
    void fedRr28() throws SystemException;
}
