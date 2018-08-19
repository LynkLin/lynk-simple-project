package com.lynk.system.exception;

import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.web.base.Response;
import com.lynk.system.web.base.ResponseFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Lynk
 * @since 2018/01/10
 */
@RestControllerAdvice
public class ExceptionController {

    /**
     * 无权限返回
     * @return
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException.class)
    public Response unauthorizedException() {
        return ResponseFactory.createFailResponse(new SystemException(ErrorCode.SYS000));
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SystemException.class)
    public Response systemException(SystemException e) {
        return ResponseFactory.createFailResponse(e);
    }

    /**
     * 统一返回
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Response exception(Exception e) {
        if (e instanceof SystemException) {
            return ResponseFactory.createFailResponse((SystemException) e);
        }
        return ResponseFactory.createFailResponse(new SystemException(ErrorCode.SYS008));
    }
}
