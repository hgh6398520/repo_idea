package com.hgy.entity.promotion;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hgy.utils.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * 广告实体类
 * @author hgy
 */
public class PromotionAd {
    /**标识*/
    private Integer id;
    /**广告名*/
    private String name;
    /**广告位id*/
    private Integer spaceId;
    /**精确搜索关键词*/
    private String keyword;
    /**静态广告内容*/
    private String htmlContent;
    /**文字内容*/
    private String text;
    /**链接一*/
    private String link;
    /**开始时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime;
    /**结束时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime;
    /**创建时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;
    /**更新时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;
    /**记录状态*/
    private Integer status;
    /**优先级*/
    private Integer priority;
    /**图片url*/
    private String img;
    /**关联广告位信息*/
    private PromotionSpace promotionSpace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public PromotionSpace getPromotionSpace() {
        return promotionSpace;
    }

    public void setPromotionSpace(PromotionSpace promotionSpace) {
        this.promotionSpace = promotionSpace;
    }

    @Override
    public String toString() {
        return "PromotionAd{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spaceId=" + spaceId +
                ", keyword='" + keyword + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", text='" + text + '\'' +
                ", link='" + link + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", priority=" + priority +
                ", img='" + img + '\'' +
                ", promotionSpace=" + promotionSpace +
                '}';
    }
}
