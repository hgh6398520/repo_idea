package com.hgy.gobal;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户查询参数
 * @author hgy
 */
public class UserVO {
    private String username;
    private Integer currentPage;
    private Integer pageSize;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startCreateTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endCreateTime;
    private List<Integer> roleIdList;
    private Integer userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "username='" + username + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", startCreateTime=" + startCreateTime +
                ", endCreateTime=" + endCreateTime +
                ", roleIdList=" + roleIdList +
                ", userId=" + userId +
                '}';
    }
}
