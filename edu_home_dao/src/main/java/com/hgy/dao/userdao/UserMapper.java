package com.hgy.dao.userdao;

import com.hgy.entity.resource.Resource;
import com.hgy.entity.role.Menu;
import com.hgy.entity.role.Role;
import com.hgy.entity.user.User;
import com.hgy.entity.user.UserRoleRelation;
import com.hgy.gobal.UserVO;
import java.util.List;

/**
 * 用户模块映射接口
 * @author hgy
 */
public interface UserMapper {
    /**多条件组合分页查询*/
    public List<User> findAllUserByPage(UserVO uvo);
    /**用户登录*/
    public User login(User user);
    /**根据用户id查询关联的角色信息*/
    public List<Role> findUserRelationRoleById(Integer id);
    /**根据用户id清空关联表*/
    public void deleteUserContextRole(Integer id);
    /**添加用户角色*/
    public void userContextRole(UserRoleRelation userRoleRelation);
    /**根据角色ID，查询角色所拥有的顶级菜单（-1）*/
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);
    /**根据PID，查询子菜单信息*/
    public List<Menu> findSubMenuByPid(Integer pid);
    /**获取用户拥有的资源权限信息*/
    public List<Resource> findResourceByRoleId(List<Integer> ids);
}
