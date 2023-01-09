package com.hgy.dao.coursedao;

import com.hgy.entity.course.Course;
import com.hgy.entity.course.CourseSection;

import java.util.List;

public interface CourseContentMapper {
    /**根据课程id查询关联课程章节与课时信息*/
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id);
    /**根据课程id查询章节对应的课程信息*/
    public Course findCourseById(Integer id);
    /**新增课程章节信息*/
    public void addCourseSection(CourseSection section);
    /**更新课程章节信息*/
    public void updateCourseSection(CourseSection section);
    /**更新课程章节状态信息*/
    public void updateCourseSectionStatus(CourseSection section);

}
