package com.lynk.system.web.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Lynk
 * @since 2017/11/15
 */
public abstract class AbstractPageRequest {
    @ApiModelProperty(value = "page number, default is 1")
    private Integer page = 1;
    @ApiModelProperty(value = "record number per page, default is 10")
    private Integer perPage = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }
}
