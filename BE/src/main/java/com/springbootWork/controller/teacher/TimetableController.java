package com.springbootWork.controller.teacher;

import com.springbootWork.config.themis.annotation.Teacher;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.teacher.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/timetable")
@RestController
public class TimetableController extends BaseController {
    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @RequestMapping
    public ResultVO get() {
        return service.get();
    }
}
