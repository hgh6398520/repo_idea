package com.hgy.service.api.course;

import com.hgy.entity.course.Course;
import com.hgy.entity.teacher.Teacher;
import com.hgy.gobal.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 课程表service层
 *
 * @author hgy
 */
public interface CourseService {
    /**
     * 多条件查询课程表
     */
    public List<Course> findCourseByCondition(CourseVO cvo);

    /**
     * 新增课程及讲师信息
     */
    public void addCourseOrTeacher(CourseVO cvo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据id查询课程及对应讲师信息
     */
    public CourseVO findCourseById(Integer id);

    /**
     * 修改课程及讲师信息
     */
    public void updateCourseOrTeacher(CourseVO cvo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 课程状态管理
     */
    public void updateCourseStatus(Integer id, Integer status);
}
