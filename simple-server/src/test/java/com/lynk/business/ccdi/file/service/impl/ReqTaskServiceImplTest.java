package com.lynk.business.ccdi.file.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.file.service.IReqTaskService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @authory: Lynk
 * @date: 2019/04/28
 */
class ReqTaskServiceImplTest extends BaseJunitTest {
    @Autowired
    private IReqTaskService reqTaskService;

    @Test
    void downloadUnzipReqFile() {
        Assertions.assertThatCode(() -> reqTaskService.downloadUnzipReqFile()).doesNotThrowAnyException();
    }

    @Test
    void parseReqZip() {
        Assertions.assertThatCode(() -> reqTaskService.parseReqZip()).doesNotThrowAnyException();
    }
}