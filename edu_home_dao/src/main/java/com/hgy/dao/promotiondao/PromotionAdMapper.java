package com.hgy.dao.promotiondao;

import com.hgy.entity.promotion.PromotionAd;

import java.util.List;

/**
 * 广告数据映射
 * @author hgy
 */
public interface PromotionAdMapper {
    /**分页查询广告信息*/
    public List<PromotionAd> findAllPromotionAdByPage();
    /**修改广告状态*/
    public void updatePromotionAdStatus(PromotionAd promotionAd);

}
