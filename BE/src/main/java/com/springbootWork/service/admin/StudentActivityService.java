package com.springbootWork.service.admin;

import com.springbootWork.manager.admin.StudentActivityManager;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class StudentActivityService extends BaseService {
    private final StudentActivityManager manager;

    public StudentActivityService(StudentActivityManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(String className, String activityName, String studentName) {
        return result(manager.getPageCount(className, activityName, studentName));
    }

    public ResultVO getPage(Integer index, String className, String activityName, String studentName) {
        return result(manager.getPage(index, className, activityName, studentName));
    }

    public ResultVO get(Integer id) {
        StudentActivityEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("学生选课Id: " + id + "不存在!");
        }

        return result(entity);
    }

    public ResultVO update(StudentActivityEntity entity) {
        StudentActivityEntity originEntity = manager.get(entity.getId());
        if (originEntity == null) {
            return failedResult("学生选课Id: " + entity.getId() + "不存在!");
        }
        if (!originEntity.getActivityId().equals(entity.getActivityId())) {
            return failedResult("课程Id被篡改");
        }
        if (!originEntity.getStudentId().equals(entity.getStudentId())) {
            return failedResult("学生Id被篡改");
        }

        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        StudentActivityEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("学生选课Id: " + id + "不存在!");
        }

        manager.delete(entity);
        return result("删除成功");
    }

    public ResultVO create(StudentActivityEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("学生选课Id: " + entity.getId() + "已存在!");
        }
        if (manager.getStudentById(entity.getStudentId()) == null) {
            return failedResult("所属学生Id: " + entity.getStudentId() + "不存在!");
        }
        if (manager.getByActivityIdAndStudentId(entity.getActivityId(), entity.getStudentId()) != null) {
            return failedResult("学生已经选修此课程");
        }
        ActivityEntity activity = manager.getActivityById(entity.getActivityId());
        if (activity == null) {
            return failedResult("所属课程Id: " + entity.getActivityId() + "不存在!");
        }
        if (activity.getSelectedCount() >= activity.getMaxSize()) {
            return failedResult("课容量已满");
        }
//        if (!manager.inSameDepartment(entity.getActivityId(), entity.getStudentId())) {
//            return failedResult("课程与学生不在同一教学系");
//        }
        if (!activity.getGrade().equals(manager.getStudentGradeById(entity.getStudentId()))) {
            return failedResult("课程与学生不在同一年级");
        }

        manager.create(entity);
        return result("添加成功");
    }
}
