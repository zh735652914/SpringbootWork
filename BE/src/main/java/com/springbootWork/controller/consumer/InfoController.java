package com.springbootWork.controller.consumer;

import com.springbootWork.config.themis.annotation.Consumer;
import com.springbootWork.controller.BaseController;
import com.springbootWork.model.vo.request.ConsumerInfoFormVO;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.consumer.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Consumer
@RequestMapping("/consumer/info")
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
    public ResultVO update(@RequestBody @Validated ConsumerInfoFormVO formVO) {
        return service.update(formVO);
    }
}
