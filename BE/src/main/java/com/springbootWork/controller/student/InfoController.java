package com.springbootWork.controller.student;

import com.springbootWork.config.themis.annotation.Student;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.vo.request.StudentInfoFormVO;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.student.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Student
@RequestMapping("/student/info")
@RestController
public class InfoController extends BaseController {
    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO formVO) {
        return service.update(formVO);
    }
}
