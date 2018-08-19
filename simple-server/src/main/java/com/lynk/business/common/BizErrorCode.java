package com.lynk.business.common;

import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.exception.annotation.ErrorCodeDefinition;
import org.springframework.stereotype.Component;

/**
 * @author Lynk
 * @since 2017/7/13.
 */
@Component
public class BizErrorCode extends ErrorCode {
    /**
     * 部门内存在岗位
     */
    @ErrorCodeDefinition(description = "部门内存在岗位")
    public static final String BASE001 = "BASE001";
}
