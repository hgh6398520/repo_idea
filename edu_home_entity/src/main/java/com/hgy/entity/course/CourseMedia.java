package com.hgy.entity.course;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hgy.utils.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * 课时媒体表实体类
 * @author hgy
 */
@JsonSerialize(using = LocalDateTimeSerializer.class)
public class CourseMedia {
    /**课程媒体id*/
    private Integer id;
    /**课程id*/
    private Integer courseId;
    /**章节id*/
    private Integer sectionId;
    /**课时id*/
    private Integer lessonId;
    /**封面图url*/
    private String coverImageUrl;
    /**时长*/
    private String duration;
    /**媒体资源文件对应的EDK*/
    private String fileEdk;
    /**文件大小(Mb)*/
    private double fileSize;
    /**文件名*/
    private String fileName;
    /**媒体资源文件对应的DK*/
    private String fileDk;
    /**记录创建时间*/
    private LocalDateTime createTime;
    /**更新时间*/
    private LocalDateTime updateTime;
    /**是否删除*/
    private Integer isDel;
    /**时长（秒）*/
    private Integer durationNum;
    /**媒体资源文件ID*/
    private String fileId;

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

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFileEdk() {
        return fileEdk;
    }

    public void setFileEdk(String fileEdk) {
        this.fileEdk = fileEdk;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDk() {
        return fileDk;
    }

    public void setFileDk(String fileDk) {
        this.fileDk = fileDk;
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

    public Integer getDurationNum() {
        return durationNum;
    }

    public void setDurationNum(Integer durationNum) {
        this.durationNum = durationNum;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "CourseMedia{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", sectionId=" + sectionId +
                ", lessonId=" + lessonId +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", duration='" + duration + '\'' +
                ", fileEdk='" + fileEdk + '\'' +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", fileDk='" + fileDk + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDel=" + isDel +
                ", durationNum=" + durationNum +
                ", fileId='" + fileId + '\'' +
                '}';
    }
}
