package com.lynk.system.security.common;

import com.lynk.system.common.Constants;

/**
 * @author Lynk
 * @since 2017/12/29
 */
public class SecurityConstants extends Constants {
    public static final String JWT_HEADER = "userToken";
    public static final String JWT_SECURITY = "lynk-sys-security";
    public static final Long JWT_LIVE_HOUR = 12L;
    public static final String PERMISSION_SPLIT = ":";
}
