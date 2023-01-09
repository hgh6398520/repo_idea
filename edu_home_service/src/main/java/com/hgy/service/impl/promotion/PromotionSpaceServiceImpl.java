package com.hgy.service.impl.promotion;

import com.hgy.dao.promotiondao.PromotionSpaceMapper;
import com.hgy.entity.promotion.PromotionSpace;
import com.hgy.service.api.promotion.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 广告位service类
 * @author hgy
 */
@Service("promotionSpaceService")
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    @Autowired
    @Qualifier("promotionSpaceMapper")
    private PromotionSpaceMapper mapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return mapper.findAllPromotionSpace();
    }

    @Override
    public void addPromotionSpace(PromotionSpace promotionSpace) {
        LocalDateTime now = LocalDateTime.now();
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        promotionSpace.setCreateTime(now);
        promotionSpace.setUpdateTime(now);

        mapper.addPromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findAllPromotionSpaceById(Integer id) {
        return mapper.findAllPromotionSpaceById(id);
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
       LocalDateTime now = LocalDateTime.now();
       promotionSpace.setUpdateTime(now);
       mapper.updatePromotionSpace(promotionSpace);
    }
}
