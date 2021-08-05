package com.springbootWork.controller.admin;

import com.springbootWork.config.themis.annotation.Admin;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.admin.StudentActivityService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin(Admin.STUDENT_ACTIVITY_MANAGE)
@RequestMapping("/admin/student/activity")
@RestController
public class StudentActivityController extends BaseController {
    private final StudentActivityService service;

    public StudentActivityController(StudentActivityService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated StudentActivityEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentActivityEntity entity) {
        return service.update(entity);
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String className, String activityName, String studentName) {
        return service.getPageCount(className, activityName, studentName);
    }

    @RequestMapping("/page")
    public ResultVO getPage(String className, String activityName, String studentName) {
        return service.getPage(1, className, activityName, studentName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String className, String activityName, String studentName) {
        return service.getPage(index, className, activityName, studentName);
    }
}
