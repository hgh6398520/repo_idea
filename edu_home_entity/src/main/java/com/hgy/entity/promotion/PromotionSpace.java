package com.hgy.entity.promotion;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hgy.utils.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * 广告位实体类
 * @author hgy
 */
public class PromotionSpace {
    /**id*/
    private Integer id;
    /**广告位名称*/
    private String name;
    /**关键字*/
    private String spaceKey;
    /**创建时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;
    /**更新时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;
    /**是否删除*/
    private Integer isDel;

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

    public String getSpaceKey() {
        return spaceKey;
    }

    public void setSpaceKey(String spaceKey) {
        this.spaceKey = spaceKey;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "PromotionSpace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spaceKey='" + spaceKey + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDel=" + isDel +
                '}';
    }
}
