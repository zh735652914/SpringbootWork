package com.springbootWork.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.response.table.*;
import com.springbootWork.model.vo.response.table.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentActivityMapper extends BaseMapper<StudentActivityEntity> {

    Integer count(String className, String activityName, String studentName);

    IPage<StudentActivityItemVO> getPage(IPage<StudentActivityItemVO> page, String className, String activityName, String studentName);

    Integer countTeacherGrade(Integer teacherId, String activityName, String studentName);

    IPage<TeacherGradeItemVO> getTeacherGradePage(IPage<TeacherGradeItemVO> page, Integer teacherId, String activityName, String studentName);

    List<StudentActivitySelectedItemVO> listStudentActivitySelected(Integer studentId);

    List<StudentExamItemVO> listStudentExam(Integer studentId);

    Integer countStudentActivitySelectedByTimePart(Integer studentId, String timePart);

    List<TimetableItemVO> listStudentTimetable(Integer studentId);
}
