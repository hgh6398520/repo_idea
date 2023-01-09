package com.hgy.controller.rolecontroller;

import com.hgy.entity.role.Menu;
import com.hgy.entity.role.Role;
import com.hgy.entity.role.RoleMenuRelation;
import com.hgy.gobal.ResponseResult;
import com.hgy.gobal.RoleMenuVO;
import com.hgy.service.api.role.RoleService;
import com.hgy.utils.SetResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("roleController")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    @Qualifier("roleService")
    private RoleService service;

    @RequestMapping("/findAllRole")
    @ResponseBody
    public ResponseResult findAllRole(@RequestBody Role role) {
        List<Role> roles = service.findAllRole(role);
        return SetResponseResult.successResponse(roles);
    }

    @RequestMapping("/findSubMenuByPid")
    @ResponseBody
    public ResponseResult findSubMenuByPid() {
        List<Menu> menus = service.findSubMenuByPid(-1);
        Map<String, List<Menu>> map = new HashMap<>();
        map.put("parentMenuList", menus);
        return SetResponseResult.successResponse(map);
    }

    @RequestMapping("/findMenuByRoleId")
    @ResponseBody
    public ResponseResult findMenuByRoleId(Integer id) {
        List<Integer> list = service.findMenuByRoleId(id);
        return SetResponseResult.successResponse(list);
    }

    @RequestMapping("/roleContextMenu")
    @ResponseBody
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVO rmvo) {
        service.roleContextMenu(rmvo);
        return SetResponseResult.successResponse(null);
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public ResponseResult deleteRole(Integer id) {
        service.deleteRole(id);
        return SetResponseResult.successResponse(null);
    }

    @RequestMapping("/findAllMenu")
    @ResponseBody
    public ResponseResult findAllMenu() {
        List<Menu> menus = service.findAllMenu();
        return SetResponseResult.successResponse(menus);
    }

    @RequestMapping("/findMenuById")
    @ResponseBody
    public ResponseResult findMenuById(Integer id) {
        List<Menu> menus = service.findSubMenuByPid(id);
        Map<String, Object> map = new HashMap<>();

        if (id == -1) {
            map.put("menuInfo", null);
            map.put("parentMenuList", menus);
        }else {
            Menu menu = service.findMenuById(id);
            map.put("menuInfo",menu);
            map.put("parentMenuList", menus);
        }
        return SetResponseResult.successResponse(map);
    }
}
