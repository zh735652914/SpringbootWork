package com.springbootWork.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootWork.dao.mapper.StudentActivityMapper;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.response.table.*;
import com.springbootWork.model.vo.response.table.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentActivityDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final StudentActivityMapper mapper;

    public StudentActivityDAO(StudentActivityMapper mapper) {
        this.mapper = mapper;
    }


    public int insert(StudentActivityEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public StudentActivityEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(StudentActivityEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String className, String activityName, String studentName) {
        return mapper.count(className, activityName, studentName);
    }

    public List<StudentActivityItemVO> getPage(Integer index, String className, String activityName, String studentName) {
        Page<StudentActivityItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, className, activityName, studentName).getRecords();
    }

    public int countByActivityId(Integer activityId) {
        LambdaQueryWrapper<StudentActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentActivityEntity::getActivityId, activityId);

        return mapper.selectCount(wrapper);
    }

    public int countByStudentId(Integer studentId) {
        LambdaQueryWrapper<StudentActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentActivityEntity::getStudentId, studentId);

        return mapper.selectCount(wrapper);
    }

    public StudentActivityEntity getByActivityIdAndStudentId(Integer activityId, Integer studentId) {
        LambdaQueryWrapper<StudentActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(StudentActivityEntity::getId)
                .eq(StudentActivityEntity::getActivityId, activityId)
                .eq(StudentActivityEntity::getStudentId, studentId);

        return mapper.selectOne(wrapper);
    }

    public List<StudentActivitySelectedItemVO> listStudentActivitySelected(Integer studentId) {
        return mapper.listStudentActivitySelected(studentId);
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return mapper.listStudentExam(studentId);
    }

    public Integer countStudentActivitySelectedByTimePart(Integer studentId, String timePart) {
        return mapper.countStudentActivitySelectedByTimePart(studentId, timePart);
    }

    public List<TimetableItemVO> listStudentTimetable(Integer studentId) {
        return mapper.listStudentTimetable(studentId);
    }

    public Integer countTeacherGrade(Integer teacherId, String activityName, String studentName) {
        return mapper.countTeacherGrade(teacherId, activityName, studentName);
    }

    public List<TeacherGradeItemVO> getTeacherGradePage(Integer index, Integer teacherId, String activityName, String studentName) {
        Page<TeacherGradeItemVO> page = new Page<>(index, PAGE_SIZE);
        return mapper.getTeacherGradePage(page, teacherId, activityName, studentName).getRecords();
    }
}
