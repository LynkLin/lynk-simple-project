package com.lynk.system.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.system.entity.SysUser;
import com.lynk.system.service.ISysUserService;
import com.lynk.system.web.request.SysUserAddRequest;
import com.lynk.system.web.request.SysUserUpdateRequest;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author Lynk
 * @since 2017/11/09
 */
public class SysUserServiceImplTest extends BaseJunitTest {
    private SysUser sysUser;
    @Autowired
    private ISysUserService sysUserServiceImpl;

    @Before
    public void setUp() throws Exception {
        sysUser = new SysUser();
        sysUser.setName("junit");
        sysUser.setPassword("junit");
        sysUser.setRealName("junit测试用户");
        sysUser.setDeleted(false);

        sysUserServiceImpl.insert(sysUser);
    }

    @After
    public void tearDown() throws Exception {
        sysUserServiceImpl.deleteById(sysUser.getId());
    }

    @Test
    @Transactional
    public void add() throws Exception {
        SysUserAddRequest user = new SysUserAddRequest();
        user.setName("test-add");
        user.setPassword("test-add");
        user.setRealName("测试用户");

        String id = sysUserServiceImpl.add(user);
        Assert.assertNotNull(id);

    }

    @Test
    public void updateRealName() throws Exception {
        SysUserUpdateRequest user = new SysUserUpdateRequest();
        user.setId(sysUser.getId());
        user.setRealName("test-update");
        sysUserServiceImpl.update(user);
        SysUser userDb = sysUserServiceImpl.getById(user.getId());
        assertEquals(userDb.getRealName(), user.getRealName());
    }

    @Test
    public void delete() throws Exception {
        sysUserServiceImpl.deleteById(sysUser.getId());
    }
}