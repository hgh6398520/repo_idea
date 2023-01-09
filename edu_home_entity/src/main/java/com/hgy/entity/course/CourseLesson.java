package com.hgy.entity.course;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hgy.utils.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * 课时表实体类
 * @author hgy
 */
@JsonSerialize(using = LocalDateTimeSerializer.class)
public class CourseLesson {
    /**课时id*/
    private Integer id;
    /**课程id*/
    private Integer courseId;
    /**课程章节id*/
    private Integer sectionId;
    /**课时主题*/
    private String theme;
    /**课时时长（分钟）*/
    private Integer duration;
    /**是否免费*/
    private Integer isFree;
    /**记录创建时间*/
    private LocalDateTime createTime;
    /**更新时间*/
    private LocalDateTime updateTime;
    /**是否删除*/
    private Integer isDel;
    /**排序字段*/
    private Integer orderNum;
    /**课时状态,0-隐藏，1-未发布，2-已发布*/
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseLesson{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", sectionId=" + sectionId +
                ", theme='" + theme + '\'' +
                ", duration=" + duration +
                ", isFree=" + isFree +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDel=" + isDel +
                ", orderNum=" + orderNum +
                ", status=" + status +
                '}';
    }
}
