package com.lynk.system.security.filter;

import com.lynk.system.common.JsonBuilder;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.security.JwtShiroToken;
import com.lynk.system.security.common.SecurityConstants;
import com.lynk.system.web.base.ResponseFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lynk
 * @since 2018/01/09
 */
public class JwtFilter extends AccessControlFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("请求地址为：{}", shiroRequest.getRequestURL());
        }
        String token = shiroRequest.getHeader(SecurityConstants.JWT_HEADER);
        JwtShiroToken jwtShiroToken = new JwtShiroToken(token);

        try {
            SecurityUtils.getSubject().login(jwtShiroToken);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        httpResponse.getWriter().write(JsonBuilder.builder().bean2Json(ResponseFactory.createFailResponse(ErrorCode.SYS002)));
        return false;
    }
}
