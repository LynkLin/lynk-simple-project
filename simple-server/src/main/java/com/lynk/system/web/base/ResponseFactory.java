package com.lynk.system.web.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lynk.system.exception.SystemException;

/**
 * @author Lynk
 * @since 2017/10/22
 */
public class ResponseFactory {
    public static Response createSuccessResponse() {
        return createSuccessResponse("", null);
    }

    public static <T> Response createSuccessResponse(T data) {
        return createSuccessResponse("", data);
    }

    public static <T> Response createSuccessResponse(String message, T data) {
        return createResponse(Response.SUCCESS, "", "", message, data);
    }

    public static Response createFailResponse(String errorCode) {
        return createFailResponse(new SystemException(errorCode));
    }

    public static Response createFailResponse(String errorCode, Object... args) {
        return createFailResponse(new SystemException(errorCode, args));
    }

    public static Response createFailResponse(SystemException e) {
        return createFailResponse(e.getErrorCode(), e.getMessage());
    }

    public static Response createFailResponse(String errorCode, String error) {
        return createResponse(Response.FAILURE, errorCode, error, "", null);
    }

    private static <T> Response createResponse(String status, String errorCode, String error, String message, T data) {
        Response<T> response = new Response<>();
        response.setStatus(status);
        response.setErrorCode(errorCode);
        response.setError(error);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static PageResponse createPageResponse(IPage data) {
        return createPageResponse("", data);
    }

    public static PageResponse createPageResponse(String message, IPage data) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setStatus(Response.SUCCESS);
        pageResponse.setErrorCode("");
        pageResponse.setError("");
        pageResponse.setMessage(message);

        pageResponse.setData(data.getRecords());

        pageResponse.setTotal(data.getTotal());
        pageResponse.setPages(data.getPages());
        pageResponse.setPerPage(data.getSize());
        pageResponse.setPage(data.getCurrent());

        return pageResponse;
    }

    public static PageResponse createFailPageResponse(SystemException e) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setStatus(Response.FAILURE);
        pageResponse.setErrorCode(e.getErrorCode());
        pageResponse.setError(e.getMessage());
        return pageResponse;
    }
}
