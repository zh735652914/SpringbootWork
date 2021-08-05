package com.springbootWork.service;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.model.vo.response.ResultVO;
import org.springframework.stereotype.Service;

@Service
public class OptionService extends BaseService {
    private final OptionManager manager;

    public OptionService(OptionManager manager) {
        this.manager = manager;
    }

    public ResultVO setAllowConsumerSelect(Boolean status) {
        manager.setAllowConsumerSelect(status);
        return result("成功");
    }

    public ResultVO getAllowConsumerSelect() {
        return result(manager.getAllowConsumerSelect());
    }

    public ResultVO setAllowTeacherGrade(Boolean status) {
        manager.setAllowTeacherGrade(status);
        return result("成功");
    }

    public ResultVO getAllowTeacherGrade() {
        return result(manager.getAllowTeacherGrade());
    }
}
