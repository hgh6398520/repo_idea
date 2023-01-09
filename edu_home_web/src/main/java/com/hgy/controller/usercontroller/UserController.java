package com.hgy.controller.usercontroller;

import com.github.pagehelper.PageInfo;
import com.hgy.entity.role.Role;
import com.hgy.entity.user.User;
import com.hgy.gobal.ResponseResult;
import com.hgy.gobal.UserVO;
import com.hgy.service.api.user.UserService;
import com.hgy.utils.SetResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户模块controller
 *
 * @author hgy
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService service;

    @RequestMapping("/findAllUserByPage")
    @ResponseBody
    public ResponseResult findAllUserByPage(@RequestBody UserVO uvo) {
        PageInfo<User> info = service.findAllUserByPage(uvo);
        return SetResponseResult.successResponse(info);
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User login = service.login(user);
        if (login != null) {
            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", login.getId());

            Map<String, Object> map = new HashMap<>();
            map.put("access_token", access_token);
            map.put("user_id", login.getId());
            map.put("user", login);
            return SetResponseResult.successResponse(map);
        } else {
            return SetResponseResult.failResponse(400, null);
        }
    }

    @RequestMapping("/findUserRoleById")
    @ResponseBody
    public ResponseResult findUserRelationRoleById(Integer id) {
        List<Role> roles = service.findUserRelationRoleById(id);
        return SetResponseResult.successResponse(roles);
    }

    @RequestMapping("/userContextRole")
    @ResponseBody
    public ResponseResult userContextRole(@RequestBody UserVO uvo) {
        service.userContextRole(uvo);
        return SetResponseResult.successResponse(null);
    }

    @RequestMapping("/getUserPermissions")
    @ResponseBody
    public ResponseResult getUserPermissions(HttpServletRequest request) {
        //获取请求头中的token
        String header_token = request.getHeader("Authorization");
        //获取session中的token
        String session_token = (String) request.getSession().getAttribute("access_token");
        //判断token是否一致
        if (!header_token.equals(session_token)) {
            return SetResponseResult.failResponse(400, null);
        } else {
            Integer id = (Integer) request.getSession().getAttribute("user_id");
            Map<String, Object> map = service.getUserPermissions(id);
            return SetResponseResult.successResponse(map);
        }
    }
}
