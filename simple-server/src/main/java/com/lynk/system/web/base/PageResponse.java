package com.lynk.system.web.base;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Lynk
 * @since 2017/10/22
 */
public class PageResponse extends Response<List> {
    /**
     * 总共条数
     */
    @ApiModelProperty(value = "total record count")
    private Long total;
    @ApiModelProperty(value = "record number per page")
    private Long perPage;
    @ApiModelProperty(value = "total number of page")
    private Long pages;
    @ApiModelProperty(value = "current page number")
    private Long page;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPerPage() {
        return perPage;
    }

    public void setPerPage(Long perPage) {
        this.perPage = perPage;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }
}
