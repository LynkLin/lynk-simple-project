package com.lynk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lynk.system.entity.SysUser;
import com.lynk.system.exception.SystemException;
import com.lynk.system.web.request.LoginRequest;
import com.lynk.system.web.response.TokenResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lynk
 * @since 2017-12-07
 */
public interface ISysAuthService extends IService<SysUser> {
    /**
     * 用户登录, 获取token
     * @param loginRequest
     * @return TokenResponse
     * @throws SystemException
     */
    TokenResponse create(LoginRequest loginRequest) throws SystemException;

    /**
     * 刷新token
     * @param token
     * @return
     * @throws SystemException
     */
    String refresh(String token) throws SystemException;

    /**
     * 删除token
     * @param token
     * @return
     * @throws SystemException
     */
    void delete(String token) throws SystemException;
}
