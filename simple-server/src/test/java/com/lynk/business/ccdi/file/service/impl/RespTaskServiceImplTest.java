package com.lynk.business.ccdi.file.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.file.service.IRespTaskService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lynk @ 2019-05-04 12:31
 */
class RespTaskServiceImplTest extends BaseJunitTest {
    @Autowired
    private IRespTaskService respTaskService;

    @Test
    void fedRr28() {
        Assertions.assertThatCode(() -> respTaskService.fedRr28()).doesNotThrowAnyException();
    }
}