package com.hgy.service.api.promotion;

import com.github.pagehelper.PageInfo;
import com.hgy.entity.promotion.PromotionAd;
import com.hgy.gobal.PromotionAdVO;

/**
 * 广告类service接口
 * @author hgy
 */
public interface PromotionAdService {
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO pavo);
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
