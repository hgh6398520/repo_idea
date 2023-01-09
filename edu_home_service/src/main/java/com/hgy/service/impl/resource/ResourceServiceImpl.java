package com.hgy.service.impl.resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgy.dao.resourcedao.ResourceMapper;
import com.hgy.entity.resource.Resource;
import com.hgy.entity.resource.ResourceCategory;
import com.hgy.gobal.ResourceVO;
import com.hgy.service.api.resource.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hgy
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    @Qualifier("resourceMapper")
    private ResourceMapper mapper;

    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVO rvo) {
        PageHelper.startPage(rvo.getCurrentPage(), rvo.getPageSize());
        List<Resource> resources = mapper.findAllResourceByPage(rvo);
        PageInfo<Resource> pageInfo = new PageInfo<>(resources);
        return pageInfo;
    }

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return mapper.findAllResourceCategory();
    }
}
