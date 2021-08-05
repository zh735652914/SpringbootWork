package com.springbootWork.controller.student;

import com.springbootWork.config.themis.annotation.Student;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.student.ActivitySelectService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Student
@RequestMapping("/student/activity/select")
@RestController
public class ActivitySelectController extends BaseController {
    private final ActivitySelectService service;

    public ActivitySelectController(ActivitySelectService service) {
        this.service = service;
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String activityName, String teacherName) {
        return service.getPageCount(activityName, teacherName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String activityName, String teacherName) {
        return service.getPage(index, activityName, teacherName);
    }

    @PostMapping("/{id}")
    public ResultVO create(@PathVariable Integer id) {
        return service.create(id);
    }
}
