package com.springbootWork.service.student;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.student.ActivityManager;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service("student_activityService")
public class ActivityService extends BaseService {
    private final ActivityManager manager;
    private final OptionManager optionManager;

    public ActivityService(ActivityManager manager, OptionManager optionManager) {
        this.manager = manager;
        this.optionManager = optionManager;
    }

    public ResultVO list() {
        Integer studentId = getUserId();
        return result(manager.listStudentActivitySelected(studentId));
    }

    public ResultVO delete(Integer studentActivityId) {
        Integer studentId = getUserId();
        if (!optionManager.getAllowStudentSelect()) {
            return failedResult("现在不是选课退课时间!");
        }
        StudentActivityEntity studentActivity = manager.getStudentActivityById(studentActivityId);
        if (studentActivity == null) {
            return failedResult("学生选课Id:" + studentActivityId + "不存在");
        }
        if (!studentActivity.getStudentId().equals(studentId)) {
            return failedResult("此课程非此学生所选!");
        }
        if (studentActivity.getDailyScore() != null || studentActivity.getExamScore() != null || studentActivity.getScore() != null) {
            return failedResult("学生已获得成绩, 不能退选");
        }

        manager.deleteStudentActivity(studentActivity);
        return result("退选成功");
    }
}
