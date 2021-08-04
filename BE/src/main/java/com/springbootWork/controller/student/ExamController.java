package com.springbootWork.controller.student;

import com.springbootWork.config.themis.annotation.Student;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.student.ExamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/exam")
@RestController
public class ExamController extends BaseController {
    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
