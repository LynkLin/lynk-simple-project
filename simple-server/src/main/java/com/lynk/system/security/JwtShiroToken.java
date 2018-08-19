package com.lynk.system.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Jwt Token
 * @author Lynk
 * @since 2018/01/08
 */
public class JwtShiroToken implements AuthenticationToken {
    /**
     * token字符串
     */
    private String token;

    public JwtShiroToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
