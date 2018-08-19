package com.lynk.business.mps.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.mps.service.IMpsReqZipService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @authory: Lynk
 * @date: 2018/08/19
 */
public class MpsReqZipServiceImplTest extends BaseJunitTest {
    @Autowired
    private IMpsReqZipService mpsReqZipServiceImpl;

    @Test
    public void insert() {
    }

    @Test
    public void selectCount() {
        int count = mpsReqZipServiceImpl.selectCount(null);
        Assert.assertEquals(0, count);
    }
}