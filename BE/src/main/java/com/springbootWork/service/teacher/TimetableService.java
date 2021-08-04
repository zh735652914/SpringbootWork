package com.springbootWork.service.teacher;

import com.springbootWork.manager.teacher.TimetableManager;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer teacherId = getUserId();
        return result(manager.listTeacherTimetable(teacherId));
    }
}
