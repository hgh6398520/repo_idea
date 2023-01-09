package com.hgy.dao.roledao;

import com.hgy.entity.role.RoleMenuRelation;
import com.hgy.entity.role.Role;

import java.util.List;

/**
 * @author hgy
 */
public interface RoleMapper {
    /**查询所有参数*/
    public List<Role> findAllRole(Role role);

    /**根据角色id查询关联菜单id*/
    public List<Integer> findMenuByRoleId(Integer id);
    /**根据角色id清空中间表的关联关系*/
    public void deleteRoleContextMenu(Integer id);
    /**为角色分配菜单*/
    public void roleContextMenu(RoleMenuRelation roleMenuRelation);
    /**删除角色*/
    public void deleteRole(Integer id);
}
