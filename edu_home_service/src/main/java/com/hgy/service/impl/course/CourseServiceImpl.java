package com.hgy.service.impl.course;

import com.hgy.dao.coursedao.CourseMapper;
import com.hgy.entity.course.Course;
import com.hgy.entity.teacher.Teacher;
import com.hgy.gobal.CourseVO;
import com.hgy.service.api.course.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hgy
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    @Qualifier("courseMapper")
    private CourseMapper mapper;

    @Override
    public List<Course> findCourseByCondition(CourseVO cvo) {
        return mapper.findCourseByCondition(cvo);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addCourseOrTeacher(CourseVO cvo) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        Teacher teacher = new Teacher();
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);

        BeanUtils.copyProperties(course, cvo);
        course.setCreateTime(date);
        course.setUpdateTime(date);
        mapper.addCourse(course);
        Integer id = course.getId();

        BeanUtils.copyProperties(teacher, cvo);
        teacher.setCourseId(id);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        mapper.addTeacher(teacher);
    }

    @Override
    public CourseVO findCourseById(Integer id) {
        return mapper.findCourseById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateCourseOrTeacher(CourseVO cvo) throws InvocationTargetException, IllegalAccessException {
        LocalDateTime date = LocalDateTime.now();

        Course course = new Course();
        BeanUtils.copyProperties(course, cvo);
        course.setUpdateTime(date);
        mapper.updateCourse(course);

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, cvo);
        teacher.setCourseId(cvo.getId());
        teacher.setUpdateTime(date);
        mapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(Integer id, Integer status) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(LocalDateTime.now());

        mapper.updateCourseStatus(course);
    }
}
