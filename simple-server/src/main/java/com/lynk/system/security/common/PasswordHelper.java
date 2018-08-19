package com.lynk.system.security.common;

import com.lynk.system.entity.SysUser;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

/**
 * @author Lynk
 * @since 2017/10/22
 */
@Component
public class PasswordHelper {
    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    /**
     * 获取随机salt
     * @return
     */
    public static String createRandomSalt() {
        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        return generator.nextBytes(5).toHex();
    }

    /**
     * 密码加密
     * @param userName
     * @param password
     * @param salt
     * @return
     */
    public static String encryptPassword(String userName, String password, String salt) {
        return new SimpleHash(algorithmName, password, userName + salt, hashIterations).toHex();
    }

    /**
     * 校验密码
     * @param password 输入的密码
     * @param sysUser 用户
     * @return
     */
    public static boolean verify(String password, SysUser sysUser) {
        String passwordTmp = encryptPassword(sysUser.getName(), password, sysUser.getSalt());
        return passwordTmp.equals(sysUser.getPassword());
    }
}
