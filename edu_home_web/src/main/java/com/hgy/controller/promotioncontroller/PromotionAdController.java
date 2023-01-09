package com.hgy.controller.promotioncontroller;


import com.github.pagehelper.PageInfo;
import com.hgy.entity.promotion.PromotionAd;
import com.hgy.gobal.FileUploadResult;
import com.hgy.gobal.PromotionAdVO;
import com.hgy.gobal.ResponseResult;
import com.hgy.service.api.promotion.PromotionAdService;
import com.hgy.utils.SetResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 广告controller类
 * @author hgy
 */
@Controller("promotionAdController")
@RequestMapping("/promotion")
public class PromotionAdController {
    @Autowired
    @Qualifier("promotionAdService")
    private PromotionAdService service;

    @RequestMapping("/findAllPromotionAdByPage")
    @ResponseBody
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO pavo){
        PageInfo<PromotionAd> info = service.findAllPromotionAdByPage(pavo);
        return SetResponseResult.successResponse(info);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ResponseResult fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("文件不能为空");
        }

        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
        String filePath = request.getServletContext().getRealPath("/");
        filePath = filePath.substring(0, filePath.indexOf("edu")) + "upload\\";


        File path = new File(filePath, newFileName);
        if (!path.getParentFile().exists()) {
            path.getParentFile().mkdirs();
        }

        file.transferTo(path);

        //返回结果
        FileUploadResult result = new FileUploadResult();
        result.setFileName(newFileName);
        result.setFilePath("http://localhost:8080/upload/" + newFileName);

        return SetResponseResult.successResponse(result);
    }

    @RequestMapping("/updatePromotionAdStatus")
    @ResponseBody
    public ResponseResult updatePromotionAdStatus(PromotionAd promotionAd){
        service.updatePromotionAdStatus(promotionAd);
        return SetResponseResult.successResponse(null);
    }
}
