package com.hgy.service.api.user;

import com.github.pagehelper.PageInfo;
import com.hgy.entity.role.Role;
import com.hgy.entity.user.User;
import com.hgy.entity.user.UserRoleRelation;
import com.hgy.gobal.UserVO;

import java.util.List;
import java.util.Map;

/**
 * 用户模块service接口
 * @author hgy
 */
public interface UserService {
    /**多条件组合分页查询*/
    public PageInfo<User> findAllUserByPage(UserVO uvo);
    /**用户登录*/
    public User login(User user) throws Exception;
    /**根据用户id查询关联的角色信息*/
    public List<Role> findUserRelationRoleById(Integer id);
    /**添加用户角色*/
    public void userContextRole(UserVO uvo);
    /**获取用户权限*/
    public Map getUserPermissions(Integer id);
}
