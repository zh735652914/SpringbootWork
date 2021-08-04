package com.springbootWork.service.student;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.student.CourseManager;
import com.springbootWork.model.entity.StudentCourseEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service("student_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;
    private final OptionManager optionManager;

    public CourseService(CourseManager manager, OptionManager optionManager) {
        this.manager = manager;
        this.optionManager = optionManager;
    }

    public ResultVO list() {
        Integer studentId = getUserId();
        return result(manager.listStudentCourseSelected(studentId));
    }

    public ResultVO delete(Integer studentCourseId) {
        Integer studentId = getUserId();
        if (!optionManager.getAllowStudentSelect()) {
            return failedResult("现在不是选课退课时间!");
        }
        StudentCourseEntity studentCourse = manager.getStudentCourseById(studentCourseId);
        if (studentCourse == null) {
            return failedResult("学生选课Id:" + studentCourseId + "不存在");
        }
        if (!studentCourse.getStudentId().equals(studentId)) {
            return failedResult("此课程非此学生所选!");
        }
        if (studentCourse.getDailyScore() != null || studentCourse.getExamScore() != null || studentCourse.getScore() != null) {
            return failedResult("学生已获得成绩, 不能退选");
        }

        manager.deleteStudentCourse(studentCourse);
        return result("退选成功");
    }
}
