package com.hgy.service.api.resource;

import com.github.pagehelper.PageInfo;
import com.hgy.entity.resource.Resource;
import com.hgy.entity.resource.ResourceCategory;
import com.hgy.gobal.ResourceVO;

import java.util.List;

/**
 * @author hgy
 */
public interface ResourceService {
    /**资源多条件分页查询*/
    public PageInfo<Resource> findAllResourceByPage(ResourceVO rvo);
    /**查询所有资源分类信息*/
    public List<ResourceCategory> findAllResourceCategory();
}
