package com.lynk.system.service.impl;

import com.lynk.base.BaseJunitTest;
import com.lynk.system.entity.SysUser;
import com.lynk.system.service.ISysUserService;
import com.lynk.system.web.request.SysUserAddRequest;
import com.lynk.system.web.request.SysUserUpdateRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lynk
 * @since 2017/11/09
 */
public class SysUserServiceImplTest extends BaseJunitTest {
    private SysUser sysUser;
    @Autowired
    private ISysUserService sysUserServiceImpl;

    @BeforeEach
    public void setUp() throws Exception {
        sysUser = new SysUser();
        sysUser.setName("junit");
        sysUser.setPassword("junit");
        sysUser.setRealName("junit测试用户");
        sysUser.setDeleted(false);

        sysUserServiceImpl.save(sysUser);
    }

    @AfterEach
    public void tearDown() throws Exception {
        sysUserServiceImpl.removeById(sysUser.getId());
    }

    @Test
    @Transactional
    public void add() throws Exception {
        SysUserAddRequest user = new SysUserAddRequest();
        user.setName("test-add");
        user.setPassword("test-add");
        user.setRealName("测试用户");

        String id = sysUserServiceImpl.add(user);
        Assertions.assertThat(id).as("新建客户ID不为空").isNotNull();
    }

    @Test
    public void updateRealName() throws Exception {
        SysUserUpdateRequest user = new SysUserUpdateRequest();
        user.setId(sysUser.getId());
        user.setRealName("test-update");
        sysUserServiceImpl.update(user);
        SysUser userDb = sysUserServiceImpl.getById(user.getId());
        Assertions.assertThat(userDb.getRealName()).as("更新realName字段").isEqualTo(user.getRealName());
    }

    @Test
    public void delete() throws Exception {
        sysUserServiceImpl.removeById(sysUser.getId());

        SysUser userDb = sysUserServiceImpl.getById(sysUser.getId());
        Assertions.assertThat(userDb).as("删除后应不存在").isNull();
    }
}