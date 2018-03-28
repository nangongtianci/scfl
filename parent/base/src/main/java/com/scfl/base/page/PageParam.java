package com.scfl.base.page;

import com.scfl.base.utils.ApplicationConst;

import java.io.Serializable;

public class PageParam implements Serializable{
    private static final long serialVersionUID = -1367700212333106887L;
    // 每页记录条数
    private Long pageSize = ApplicationConst.DEFAULT_PAGE_SIZE;
    // 当前第几页
    private Long pageCurrent;

    public Long getPageSize() {
        if (pageSize.longValue() > ApplicationConst.MAX_PAGE_SIZE) {
            return ApplicationConst.MAX_PAGE_SIZE;
        }else if(pageSize.longValue() < 0){
            return ApplicationConst.DEFAULT_PAGE_SIZE;
        }else{
            return pageSize;
        }
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
}
