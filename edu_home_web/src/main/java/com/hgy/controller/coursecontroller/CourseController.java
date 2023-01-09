package com.hgy.controller.coursecontroller;

import com.hgy.entity.course.Course;
import com.hgy.gobal.CourseVO;
import com.hgy.gobal.FileUploadResult;
import com.hgy.gobal.ResponseResult;
import com.hgy.service.api.course.CourseService;
import com.hgy.utils.SetResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgy
 */
@Controller("courseController")
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("courseService")
    private CourseService service;

    @RequestMapping("/findCourseByCondition")
    @ResponseBody
    public ResponseResult findCourseByCondition(@RequestBody CourseVO cvo) {
        List<Course> courseList = service.findCourseByCondition(cvo);
        return SetResponseResult.successResponse(courseList);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ResponseResult fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("文件不能为空");
        }

        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
        String filePath = request.getServletContext().getRealPath("/");
        filePath = filePath.substring(0, filePath.indexOf("edu")) + "upload\\";


        File path = new File(filePath, newFileName);
        if (!path.getParentFile().exists()) {
            path.getParentFile().mkdirs();
        }

        file.transferTo(path);

        //返回结果
        FileUploadResult result = new FileUploadResult();
        result.setFileName(newFileName);
        result.setFilePath("http://localhost:8080/upload/" + newFileName);

        return SetResponseResult.successResponse(result);
    }

    @RequestMapping("/addCourseOrTeacher")
    @ResponseBody
    public ResponseResult addCourseOrTeacher(@RequestBody CourseVO cvo) {
        try {
            service.addCourseOrTeacher(cvo);
            return SetResponseResult.successResponse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return SetResponseResult.failResponse(400, null);
        }
    }

    @RequestMapping("/findCourseById")
    @ResponseBody
    public ResponseResult findCourseById(int id) {
        CourseVO cvo = service.findCourseById(id);
        return SetResponseResult.successResponse(cvo);
    }

    @RequestMapping("/updateCourseOrTeacher")
    @ResponseBody
    public ResponseResult updateCourseOrTeacher(@RequestBody CourseVO cvo) {
        try {
            service.updateCourseOrTeacher(cvo);
            return SetResponseResult.successResponse(null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return SetResponseResult.failResponse(400, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return SetResponseResult.failResponse(400, null);
        }
    }

    @RequestMapping("/updateCourseStatus")
    @ResponseBody
    public ResponseResult updateCourseStatus(Integer id, int status) {
        service.updateCourseStatus(id, status);

        Map<String, Integer> map = new HashMap<>();
        map.put("status", status);
        return SetResponseResult.successResponse(map);
    }
}
