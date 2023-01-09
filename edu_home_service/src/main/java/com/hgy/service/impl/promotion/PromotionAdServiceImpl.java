package com.hgy.service.impl.promotion;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgy.dao.promotiondao.PromotionAdMapper;
import com.hgy.entity.promotion.PromotionAd;
import com.hgy.gobal.PromotionAdVO;
import com.hgy.service.api.promotion.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("promotionAdService")
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    @Qualifier("promotionAdMapper")
    private PromotionAdMapper mapper;

    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO pavo) {
        PageHelper.startPage(pavo.getCurrentPage(), pavo.getPageSize());
        List<PromotionAd> promotionAds = mapper.findAllPromotionAdByPage();
        return new PageInfo<PromotionAd>(promotionAds);
    }

    @Override
    public void updatePromotionAdStatus(PromotionAd promotionAd) {
        LocalDateTime now = LocalDateTime.now();
        promotionAd.setUpdateTime(now);
        mapper.updatePromotionAdStatus(promotionAd);
    }
}
