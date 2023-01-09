package com.hgy.gobal;

/**
 * 用于接收广告信息查询条件参数
 * @author hgy
 */
public class PromotionAdVO {
    /**当前页*/
    private Integer currentPage;
    /**每页查询记录数*/
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PromotionAdVO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
