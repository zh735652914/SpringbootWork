package com.springbootWork.controller.admin;

import com.springbootWork.config.themis.annotation.Admin;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.entity.AdminEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.admin.AdminService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin(Admin.ADMIN_MANAGE)
@RequestMapping("/admin/admin")
@RestController
public class AdminController extends BaseController {
    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated AdminEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated AdminEntity entity) {
        return service.update(entity);
    }

    @GetMapping()
    public ResultVO list() {
        return service.list();
    }
}
