package com.hgy.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgy.dao.userdao.UserMapper;
import com.hgy.entity.resource.Resource;
import com.hgy.entity.role.Menu;
import com.hgy.entity.role.Role;
import com.hgy.entity.user.User;
import com.hgy.entity.user.UserRoleRelation;
import com.hgy.gobal.UserVO;
import com.hgy.service.api.user.UserService;
import com.hgy.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author hgy
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper mapper;

    @Override
    public PageInfo<User> findAllUserByPage(UserVO uvo) {
        PageHelper.startPage(uvo.getCurrentPage(), uvo.getPageSize());
        List<User> users = mapper.findAllUserByPage(uvo);
        return new PageInfo<User>(users);
    }

    @Override
    public User login(User user) throws Exception {
        User login = mapper.login(user);
        if (login != null && Md5.verify(user.getPassword(), "lagou", login.getPassword())) {
            return login;
        } else {
            return null;
        }

    }

    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        return mapper.findUserRelationRoleById(id);
    }

    @Override
    @Transactional
    public void userContextRole(UserVO uvo) {
        mapper.deleteUserContextRole(uvo.getUserId());

        for (Integer id : uvo.getRoleIdList()) {
            UserRoleRelation urr = new UserRoleRelation();
            Date date = new Date();
            urr.setRoleId(id);
            urr.setUserId(uvo.getUserId());
            urr.setCreatedTime(date);
            urr.setUpdatedTime(date);
            urr.setCreatedBy("system");
            urr.setUpdatedBy("system");

            mapper.userContextRole(urr);
        }

    }

    @Override
    public Map getUserPermissions(Integer id) {
        Map<String, Object> map = new HashMap<>();
        ArrayList<Integer> ids = new ArrayList<>();
        List<Role> roles = mapper.findUserRelationRoleById(id);
        for (Role role : roles) {
            ids.add(role.getId());
        }

        ids.add(1);

        List<Menu> menus = mapper.findParentMenuByRoleId(ids);
        for (Menu menu : menus) {
            menu.setMenus(mapper.findSubMenuByPid(menu.getId()));
        }

        List<Resource> resources = mapper.findResourceByRoleId(ids);

        map.put("menuList",menus);
        map.put("resourceList",resources);
        return map;
    }
}
