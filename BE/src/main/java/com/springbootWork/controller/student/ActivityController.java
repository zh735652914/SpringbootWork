package com.springbootWork.controller.student;

import com.springbootWork.config.themis.annotation.Student;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.student.ActivityService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/activity")
@RestController("student_activityController")
public class ActivityController extends BaseController {
    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }
}
