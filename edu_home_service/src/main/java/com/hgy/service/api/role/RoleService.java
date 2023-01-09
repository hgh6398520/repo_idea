package com.hgy.service.api.role;

import com.hgy.entity.role.Menu;
import com.hgy.entity.role.RoleMenuRelation;
import com.hgy.entity.role.Role;
import com.hgy.gobal.RoleMenuVO;

import java.util.List;

public interface RoleService {
    /**查询所有参数*/
    public List<Role> findAllRole(Role role);
    /**根据角色id查询关联菜单id*/
    public List<Integer> findMenuByRoleId(Integer id);
    /**查询所有父子菜单信息*/
    public List<Menu> findSubMenuByPid(Integer id);
    /**为角色分配菜单*/
    public void roleContextMenu(RoleMenuVO rmvo);
    /**删除角色*/
    public void deleteRole(Integer id);
    /**查询所有菜单信息*/
    public List<Menu> findAllMenu();
    /**根据id查询菜单信息*/
    public Menu findMenuById(Integer id);
}
