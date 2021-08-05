package com.springbootWork.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootWork.model.bo.ActivityItemBO;
import com.springbootWork.model.bo.StudentActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapper extends BaseMapper<ActivityEntity> {
    Integer count(String departmentName, String teacherName, String name);

//    Integer count(String teacherName, String name);

    IPage<ActivityItemBO> getPage(IPage<ActivityItemBO> page, String departmentName, String teacherName, String name);

//    Integer countStudentCanSelect(Integer studentId, Integer departmentId, Integer grade, String activityName, String teacherName);

    Integer countStudentCanSelect(Integer studentId, Integer departmentId, Integer grade, String activityName, String teacherName);

    IPage<StudentActivitySelectItemBO> getStudentCanSelectPage(IPage<StudentActivitySelectItemBO> page, Integer studentId, Integer departmentId, Integer grade, String activityName, String teacherName);

//    IPage<StudentActivitySelectItemBO> getStudentCanSelectPage(IPage<StudentActivitySelectItemBO> page, Integer studentId, String activityName, String teacherName);

    Integer getDepartmentIdById(Integer activityId);
}
