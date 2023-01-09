package com.hgy.dao.roledao;

import com.hgy.entity.role.Menu;

import java.util.List;

/**
 * @author hgy
 */
public interface MenuMapper {
    /**查询所有父子菜单信息*/
    public List<Menu> findSubMenuByPid(Integer id);
    /**查询所有菜单信息*/
    public List<Menu> findAllMenu();
    /**根据id查询菜单信息*/
    public Menu findMenuById(Integer id);
}
