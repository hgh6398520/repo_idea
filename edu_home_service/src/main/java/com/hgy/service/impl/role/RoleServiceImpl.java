package com.hgy.service.impl.role;

import com.hgy.dao.roledao.MenuMapper;
import com.hgy.dao.roledao.RoleMapper;
import com.hgy.entity.role.Menu;
import com.hgy.entity.role.Role;
import com.hgy.entity.role.RoleMenuRelation;
import com.hgy.gobal.RoleMenuVO;
import com.hgy.service.api.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    @Qualifier("roleMapper")
    private RoleMapper roleMapper;

    @Autowired
    @Qualifier("menuMapper")
    private MenuMapper menuMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer id) {
        return roleMapper.findMenuByRoleId(id);
    }

    @Override
    public List<Menu> findSubMenuByPid(Integer id) {
        return menuMapper.findSubMenuByPid(id);
    }

    @Override
    @Transactional
    public void roleContextMenu(RoleMenuVO rmvo) {
        roleMapper.deleteRoleContextMenu(rmvo.getRoleId());

        for(Integer id : rmvo.getMenuIdList()){
            Date date = new Date();
            RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
            roleMenuRelation.setMenuId(id);
            roleMenuRelation.setRoleId(rmvo.getRoleId());
            roleMenuRelation.setCreatedTime(date);
            roleMenuRelation.setUpdatedTime(date);
            roleMenuRelation.setUpdatedBy("system");
            roleMenuRelation.setCreatedBy("system");

            roleMapper.roleContextMenu(roleMenuRelation);
        }
    }

    @Override
    @Transactional
    public void deleteRole(Integer id) {
        roleMapper.deleteRoleContextMenu(id);
        roleMapper.deleteRole(id);
    }

    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }
}
