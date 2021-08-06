package com.springbootWork.controller;

import com.springbootWork.config.themis.annotation.NoLimit;
import com.springbootWork.config.themis.annotation.Visitor;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.VisitorService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Visitor
@RequestMapping("/visitor/activity/select")
@RestController
public class VisitorController extends BaseController {
    private final VisitorService service;

    public VisitorController(VisitorService service) {
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
}
