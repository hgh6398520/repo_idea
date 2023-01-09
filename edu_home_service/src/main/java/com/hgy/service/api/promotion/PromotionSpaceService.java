package com.hgy.service.api.promotion;

import com.hgy.entity.promotion.PromotionSpace;

import java.util.List;

/**
 * 广告位service接口
 * @author hgy
 */
public interface PromotionSpaceService {
    /**查询所有广告位*/
    public List<PromotionSpace> findAllPromotionSpace();
    /**新增广告位*/
    public void addPromotionSpace(PromotionSpace promotionSpace);
    /**根据id查询广告位*/
    public PromotionSpace findAllPromotionSpaceById(Integer id);
    /**更新广告位信息*/
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
