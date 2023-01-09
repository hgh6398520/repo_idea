package com.hgy.entity.course;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hgy.utils.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 章节表实体类
 * @author hgy
 */
@JsonSerialize(using = LocalDateTimeSerializer.class)
public class CourseSection {
    /**章节id*/
    private Integer id;
    /**课程id*/
    private Integer courseId;
    /**章节名*/
    private String sectionName;
    /**章节描述*/
    private String description;
    /**记录创建时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;
    /**更新时间*/
    private LocalDateTime updateTime;
    /**是否删除*/
    private Integer isDel;
    /**排序字段*/
    private Integer orderNum;
    /**状态，0:隐藏；1：待更新；2：已发布*/
    private Integer status;
    /**课时信息*/
    private List<CourseLesson> lessons;

    public List<CourseLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<CourseLesson> lessons) {
        this.lessons = lessons;
    }

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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "CourseSection{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", sectionName='" + sectionName + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDel=" + isDel +
                ", orderNum=" + orderNum +
                ", status=" + status +
                '}';
    }
}
