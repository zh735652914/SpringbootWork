package com.springbootWork.service.teacher;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.teacher.GradeManager;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.TeacherGradeVO;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GradeService extends BaseService {
    private final GradeManager manager;
    private final OptionManager optionManager;

    public GradeService(GradeManager manager, OptionManager optionManager) {
        this.manager = manager;
        this.optionManager = optionManager;
    }

    public ResultVO getPageCount(String activityName, String studentName) {
        Integer teacherId = getUserId();
        return result(manager.getTeacherGradePageCount(teacherId, activityName, studentName));
    }

    public ResultVO getPage(Integer index, String activityName, String studentName) {
        Integer teacherId = getUserId();
        return result(manager.getTeacherGradePage(index, teacherId, activityName, studentName));
    }

    public ResultVO update(TeacherGradeVO vo) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        StudentActivityEntity studentActivity = manager.getStudentActivityById(vo.getStudentActivityId());
        if (studentActivity == null) {
            return failedResult("学生选课Id:" + vo.getStudentActivityId() + "不存在");
        }
        if (!manager.getActivityById(studentActivity.getActivityId()).getTeacherId().equals(teacherId)) {
            return failedResult("此课程非您教授");
        }

        BeanUtils.copyProperties(vo, studentActivity);

        manager.updateStudentActivity(studentActivity);
        return result("打分成功");
    }

    public ResultVO get(Integer studentActivityId) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        StudentActivityEntity studentActivity = manager.getStudentActivityById(studentActivityId);
        if (studentActivity == null) {
            return failedResult("学生选课Id:" + studentActivityId + "不存在");
        }
        if (!manager.getActivityById(studentActivity.getActivityId()).getTeacherId().equals(teacherId)) {
            return failedResult("此课程非您教授");
        }

        TeacherGradeVO vo = new TeacherGradeVO();
        BeanUtils.copyProperties(studentActivity, vo);
        vo.setStudentActivityId(studentActivityId);

        return result(vo);
    }
}
