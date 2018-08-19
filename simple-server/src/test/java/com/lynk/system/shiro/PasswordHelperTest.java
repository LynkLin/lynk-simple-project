package com.lynk.system.shiro;

import com.lynk.base.BaseJunitTest;
import com.lynk.system.entity.SysUser;
import com.lynk.system.security.common.PasswordHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lynk
 * Date: 2017/8/5
 * Time: 22:03
 */
public class PasswordHelperTest extends BaseJunitTest {
    @Test
    public void testEncryptPassword() {
        String password = "admin";
        String salt = PasswordHelper.createRandomSalt();
        System.out.println(salt);
        String password2 = PasswordHelper.encryptPassword("admin", password, salt);
        System.out.println(password2);

        SysUser sysUser = new SysUser();
        sysUser.setName("admin");
        sysUser.setSalt(salt);
        sysUser.setPassword(password2);

        boolean result = PasswordHelper.verify(password, sysUser);
        Assert.assertTrue(result);
    }
}
