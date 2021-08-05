package com.springbootWork.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.vo.response.table.*;
import com.springbootWork.model.vo.response.table.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerActivityMapper extends BaseMapper<ConsumerActivityEntity> {

    Integer count(String className, String activityName, String consumerName);

    IPage<ConsumerActivityItemVO> getPage(IPage<ConsumerActivityItemVO> page, String className, String activityName, String consumerName);

    Integer countTeacherGrade(Integer teacherId, String activityName, String consumerName);

    IPage<TeacherGradeItemVO> getTeacherGradePage(IPage<TeacherGradeItemVO> page, Integer teacherId, String activityName, String consumerName);

    List<ConsumerActivitySelectedItemVO> listConsumerActivitySelected(Integer consumerId);

    List<ConsumerExamItemVO> listConsumerExam(Integer consumerId);

    Integer countConsumerActivitySelectedByTimePart(Integer consumerId, String timePart);

    List<TimetableItemVO> listConsumerTimetable(Integer consumerId);
}
