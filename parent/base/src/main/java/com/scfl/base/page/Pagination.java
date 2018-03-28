package com.scfl.base.page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scfl.base.utils.ApplicationConst;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = -9032902800051446811L;

    protected long DEFAULT_PAGE_SIZE = ApplicationConst.DEFAULT_PAGE_SIZE;
    protected long MAX_PAGE_SIZE = ApplicationConst.MAX_PAGE_SIZE;

    /**
     * 实体的list
     */
    private List<T> list = new ArrayList<>();

    /**
     * 总记录条数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long totalPage = 0l;

    /**
     * 每页记录条数
     */
    private Long pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 当前页
     */
    private Long pageCurrent;

    /**
     * 起始行,用于页面序号相加
     */
    @JsonIgnore
    private Long pageStart = 0l;

    public Pagination(){

    }

    public Pagination(Long pageCurrent, Long pageSize, Long total) {
        if (pageSize.longValue() > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
        }
        if (pageSize.longValue() > 0 && pageSize.longValue() <= MAX_PAGE_SIZE) {
            this.pageSize = pageSize;
        }
        this.pageCurrent = pageCurrent;
        this.total = total;

        if (total > 0) {
            this.totalPage = (total + pageSize - 1) / pageSize;
            this.pageStart = pageSize * (pageCurrent - 1);
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Long pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Long getPageStart() {
        return pageStart;
    }

    public void setPageStart(Long pageStart) {
        this.pageStart = pageStart;
    }
}
