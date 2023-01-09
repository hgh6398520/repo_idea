package com.hgy.gobal;

import java.util.List;

/**
 * @author hgy
 */
public class RoleMenuVO {
    private Integer roleId;
    private List<Integer> menuIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Integer> menuIdList) {
        this.menuIdList = menuIdList;
    }

    @Override
    public String toString() {
        return "RoleMenuVO{" +
                "roleId=" + roleId +
                ", menuIdList=" + menuIdList +
                '}';
    }
}
