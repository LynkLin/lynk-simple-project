package com.lynk.business.ccdi.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.service.IReqTaskService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lynk @ 2019/04/23
 */
public class ReqTaskServiceImplTest extends BaseJunitTest {
    @Autowired
    private IReqTaskService reqTaskService;

    @Test
    public void downloadReqFile() {
        Assertions.assertThatCode(() -> reqTaskService.downloadUnzipReqFile()).doesNotThrowAnyException();
    }


}