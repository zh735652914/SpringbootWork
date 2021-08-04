package com.springbootWork.service.student;

import com.springbootWork.manager.student.ExamManager;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends BaseService {
    private final ExamManager manager;

    public ExamService(ExamManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        return result(manager.listStudentExam(getUserId()));
    }
}
