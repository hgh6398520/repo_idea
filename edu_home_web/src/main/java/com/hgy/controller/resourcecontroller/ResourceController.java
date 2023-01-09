package com.hgy.controller.resourcecontroller;

import com.github.pagehelper.PageInfo;
import com.hgy.entity.resource.Resource;
import com.hgy.entity.resource.ResourceCategory;
import com.hgy.gobal.ResourceVO;
import com.hgy.gobal.ResponseResult;
import com.hgy.service.api.resource.ResourceService;
import com.hgy.utils.SetResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hgy
 */
@Controller("resourceController")
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    @Qualifier("resourceService")
    private ResourceService service;

    @RequestMapping("/findAllResourceByPage")
    @ResponseBody
    public ResponseResult findAllResourceByPage(@RequestBody ResourceVO rvo){
        PageInfo<Resource> pageInfo = service.findAllResourceByPage(rvo);
        return SetResponseResult.successResponse(pageInfo);
    }

    @RequestMapping("/findAllResourceCategory")
    @ResponseBody
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = service.findAllResourceCategory();
        return SetResponseResult.successResponse(allResourceCategory);
    }
}
