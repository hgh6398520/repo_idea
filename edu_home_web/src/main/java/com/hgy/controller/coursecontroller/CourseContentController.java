package com.hgy.controller.coursecontroller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hgy.entity.course.Course;
import com.hgy.entity.course.CourseSection;
import com.hgy.gobal.ResponseResult;
import com.hgy.service.api.course.CourseContentService;
import com.hgy.utils.LocalDateTimeSerializer;
import com.hgy.utils.SetResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgy
 */
@Controller("courseContentController")
@RequestMapping("/courseContent")
@JsonSerialize(using = LocalDateTimeSerializer.class)
public class CourseContentController {
    @Autowired
    @Qualifier("courseContentService")
    private CourseContentService service;

    @RequestMapping("/findSectionAndLesson")
    @ResponseBody
    public ResponseResult findSectionAndLessonByCourseId(Integer id) {
        List<CourseSection> courseSections = service.findSectionAndLessonByCourseId(id);
        return SetResponseResult.successResponse(courseSections);
    }

    @RequestMapping("/findCourseById")
    @ResponseBody
    public ResponseResult findCourseById(Integer id) {
        Course course = service.findCourseById(id);
        return SetResponseResult.successResponse(course);
    }

    @RequestMapping("/addCourseSection")
    @ResponseBody
    public ResponseResult addCourseSection(@RequestBody CourseSection section) {
        service.addCourseSection(section);
        return SetResponseResult.successResponse(null);
    }

    @RequestMapping("/updateCourseSection")
    @ResponseBody
    public ResponseResult updateCourseSection(@RequestBody CourseSection section) {
        service.updateCourseSection(section);
        return SetResponseResult.successResponse(null);
    }

    @RequestMapping("/updateCourseSectionStatus")
    @ResponseBody
    public ResponseResult updateCourseSectionStatus(Integer id, Integer status) {
        service.updateCourseSectionStatus(id, status);
        Map<String, Integer> map = new HashMap<>();
        map.put("status", status);
        return SetResponseResult.successResponse(map);
    }

}
