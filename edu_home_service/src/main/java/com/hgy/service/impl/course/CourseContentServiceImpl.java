package com.hgy.service.impl.course;

import com.hgy.dao.coursedao.CourseContentMapper;
import com.hgy.entity.course.Course;
import com.hgy.entity.course.CourseSection;
import com.hgy.service.api.course.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hgy
 */
@Service("courseContentService")
public class CourseContentServiceImpl implements CourseContentService {
    @Autowired
    @Qualifier("courseContentMapper")
    private CourseContentMapper mapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id) {
        return mapper.findSectionAndLessonByCourseId(id);
    }

    @Override
    public Course findCourseById(Integer id) {
        return mapper.findCourseById(id);
    }

    @Override
    public void addCourseSection(CourseSection section) {
        LocalDateTime now = LocalDateTime.now();

        section.setCreateTime(now);
        section.setUpdateTime(now);
        mapper.addCourseSection(section);
    }

    @Override
    public void updateCourseSection(CourseSection section) {
        LocalDateTime now = LocalDateTime.now();
        section.setUpdateTime(now);
        mapper.updateCourseSection(section);
    }

    @Override
    public void updateCourseSectionStatus(Integer id, Integer status) {
        LocalDateTime now = LocalDateTime.now();
        CourseSection section = new CourseSection();
        section.setId(id);
        section.setStatus(status);
        section.setUpdateTime(now);
        mapper.updateCourseSectionStatus(section);
    }
}
