package com.springbootWork.controller.teacher;

import com.springbootWork.config.themis.annotation.Teacher;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.teacher.ActivityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/activity")
@RestController("teacher_activityController")
public class ActivityController extends BaseController {
    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
