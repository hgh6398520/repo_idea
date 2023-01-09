package com.hgy.dao.coursedao;

import com.hgy.entity.course.Course;
import com.hgy.entity.course.CourseSection;
import com.hgy.entity.teacher.Teacher;
import com.hgy.gobal.CourseVO;
import java.util.List;

/**
 * 课程表映射接口
 * @author hgy
 */
public interface CourseMapper {
    /**多条件查询课程表*/
    public List<Course> findCourseByCondition(CourseVO cvo);
    /**新增课程信息*/
    public void addCourse(Course course);
    /**新增讲师信息*/
    public void addTeacher(Teacher teacher);
    /**根据id查询课程及对应讲师信息*/
    public CourseVO findCourseById(Integer id);
    /**修改课程信息*/
    public void updateCourse(Course course);
    /**修改讲师信息*/
    public void updateTeacher(Teacher teacher);
    /**课程状态管理*/
    public void updateCourseStatus(Course course);
}
