package com.springbootWork.controller.admin;

import com.springbootWork.config.themis.annotation.Admin;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.admin.ConsumerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin(Admin.CONSUMER_MANAGE)
@RequestMapping("/admin/consumer")
@RestController
public class ConsumerController extends BaseController {
    private final ConsumerService service;

    public ConsumerController(ConsumerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated ConsumerEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated ConsumerEntity entity) {
        return service.update(entity);
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String className, String name) {
        return service.getPageCount(className, name);
    }

    @RequestMapping("/page")
    public ResultVO getPage(String name) {
        return service.getPage(1, name);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String name) {
        return service.getPage(index, name);
    }

    @Admin
    @RequestMapping("/names")
    public ResultVO listName() {
        return service.listName();
    }
}
