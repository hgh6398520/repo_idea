package com.hgy.controller.promotioncontroller;

import com.hgy.entity.promotion.PromotionSpace;
import com.hgy.gobal.ResponseResult;
import com.hgy.service.api.promotion.PromotionSpaceService;
import com.hgy.utils.SetResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 广告位Controller类
 * @author hgy
 */
@Controller("promotionSpaceController")
@RequestMapping("/promotion")
public class PromotionSpaceController {
    @Autowired
    @Qualifier("promotionSpaceService")
    private PromotionSpaceService service;

    @RequestMapping("/findAllPromotionSpace")
    @ResponseBody
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> promotionSpaces = service.findAllPromotionSpace();
        return SetResponseResult.successResponse(promotionSpaces);
    }

    @RequestMapping("/findAllPromotionSpaceById")
    @ResponseBody
    public ResponseResult findAllPromotionSpaceById(Integer id){
        PromotionSpace promotionSpace = service.findAllPromotionSpaceById(id);
        return SetResponseResult.successResponse(promotionSpace);
    }

    @RequestMapping("/addPromotionSpace")
    @ResponseBody
    public ResponseResult addPromotionSpace(@RequestBody PromotionSpace promotionSpace){
        service.addPromotionSpace(promotionSpace);
        return SetResponseResult.successResponse(null);
    }

    @RequestMapping("/updatePromotionSpace")
    @ResponseBody
    public ResponseResult updatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        service.updatePromotionSpace(promotionSpace);
        return SetResponseResult.successResponse(null);
    }
}
