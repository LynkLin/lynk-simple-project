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
    private Integer perPage;
    @ApiModelProperty(value = "total number of page")
    private Long pages;
    @ApiModelProperty(value = "current page number")
    private Integer page;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
