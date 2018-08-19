package com.lynk.system.controller;


import com.lynk.system.exception.SystemException;
import com.lynk.system.log.annotation.SystemLog;
import com.lynk.system.service.ISysAuthService;
import com.lynk.system.web.request.LoginRequest;
import com.lynk.system.web.base.Response;
import com.lynk.system.web.base.ResponseFactory;
import com.lynk.system.web.response.TokenResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lynk
 * @since 2017-12-07
 */
@RestController
@Api(value = "system auth", description = "auth manage")
@RequestMapping("v1/system/auth")
public class SysAuthController {
    @Autowired
    private ISysAuthService sysAuthServiceImpl;

    @ApiOperation(value = "create token")
    @PostMapping(value="/")
    @SystemLog(description = "create token")
    public Response create(LoginRequest loginRequest) {
        try {
            TokenResponse tokenResponse = sysAuthServiceImpl.create(loginRequest);
            return ResponseFactory.createSuccessResponse(tokenResponse);
        } catch (SystemException e) {
            return ResponseFactory.createFailResponse(e);
        }
    }

    @ApiOperation(value = "refresh token")
    @PutMapping(value="/")
    @SystemLog(description = "refresh token")
    public Response refresh(String token) {
        try {
            String newToken = sysAuthServiceImpl.refresh(token);
            return ResponseFactory.createSuccessResponse(newToken);
        } catch (SystemException e) {
            return ResponseFactory.createFailResponse(e);
        }
    }

    @ApiOperation(value = "delete token")
    @DeleteMapping(value="/")
    @SystemLog(description = "delete token")
    public Response delete(String token) {
        try {
           sysAuthServiceImpl.delete(token);
            return ResponseFactory.createSuccessResponse();
        } catch (SystemException e) {
            return ResponseFactory.createFailResponse(e);
        }
    }
}
