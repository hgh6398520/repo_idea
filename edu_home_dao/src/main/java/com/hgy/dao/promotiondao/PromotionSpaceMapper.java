package com.hgy.dao.promotiondao;

import com.hgy.entity.promotion.PromotionSpace;

import java.util.List;

/**
 * 广告位数据库映射类
 * @author hgy
 */
public interface PromotionSpaceMapper {
    /**查询所有广告位*/
    public List<PromotionSpace> findAllPromotionSpace();
    /**添加广告位*/
    public void addPromotionSpace(PromotionSpace promotionSpace);
    /**根据id查询广告位*/
    public PromotionSpace findAllPromotionSpaceById(Integer id);
    /**更新广告位信息*/
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
