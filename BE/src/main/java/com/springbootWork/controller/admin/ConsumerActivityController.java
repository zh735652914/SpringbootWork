package com.springbootWork.controller.admin;

import com.springbootWork.config.themis.annotation.Admin;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.admin.ConsumerActivityService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin(Admin.CONSUMER_ACTIVITY_MANAGE)
@RequestMapping("/admin/consumer/activity")
@RestController
public class ConsumerActivityController extends BaseController {
    private final ConsumerActivityService service;

    public ConsumerActivityController(ConsumerActivityService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated ConsumerActivityEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated ConsumerActivityEntity entity) {
        return service.update(entity);
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String className, String activityName, String consumerName) {
        return service.getPageCount(className, activityName, consumerName);
    }

    @RequestMapping("/page")
    public ResultVO getPage(String className, String activityName, String consumerName) {
        return service.getPage(1, className, activityName, consumerName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String className, String activityName, String consumerName) {
        return service.getPage(index, className, activityName, consumerName);
    }
}
