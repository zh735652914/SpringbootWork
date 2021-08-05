package com.springbootWork.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootWork.dao.mapper.ConsumerActivityMapper;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.vo.response.table.*;
import com.springbootWork.model.vo.response.table.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsumerActivityDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final ConsumerActivityMapper mapper;

    public ConsumerActivityDAO(ConsumerActivityMapper mapper) {
        this.mapper = mapper;
    }


    public int insert(ConsumerActivityEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public ConsumerActivityEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(ConsumerActivityEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String className, String activityName, String consumerName) {
        return mapper.count(className, activityName, consumerName);
    }

    public List<ConsumerActivityItemVO> getPage(Integer index, String className, String activityName, String consumerName) {
        Page<ConsumerActivityItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, className, activityName, consumerName).getRecords();
    }

    public int countByActivityId(Integer activityId) {
        LambdaQueryWrapper<ConsumerActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ConsumerActivityEntity::getActivityId, activityId);

        return mapper.selectCount(wrapper);
    }

    public int countByConsumerId(Integer consumerId) {
        LambdaQueryWrapper<ConsumerActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ConsumerActivityEntity::getConsumerId, consumerId);

        return mapper.selectCount(wrapper);
    }

    public ConsumerActivityEntity getByActivityIdAndConsumerId(Integer activityId, Integer consumerId) {
        LambdaQueryWrapper<ConsumerActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(ConsumerActivityEntity::getId)
                .eq(ConsumerActivityEntity::getActivityId, activityId)
                .eq(ConsumerActivityEntity::getConsumerId, consumerId);

        return mapper.selectOne(wrapper);
    }

    public List<ConsumerActivitySelectedItemVO> listConsumerActivitySelected(Integer consumerId) {
        return mapper.listConsumerActivitySelected(consumerId);
    }

    public List<ConsumerExamItemVO> listConsumerExam(Integer consumerId) {
        return mapper.listConsumerExam(consumerId);
    }

    public Integer countConsumerActivitySelectedByTimePart(Integer consumerId, String timePart) {
        return mapper.countConsumerActivitySelectedByTimePart(consumerId, timePart);
    }

    public List<TimetableItemVO> listConsumerTimetable(Integer consumerId) {
        return mapper.listConsumerTimetable(consumerId);
    }

    public Integer countTeacherGrade(Integer teacherId, String activityName, String consumerName) {
        return mapper.countTeacherGrade(teacherId, activityName, consumerName);
    }

    public List<TeacherGradeItemVO> getTeacherGradePage(Integer index, Integer teacherId, String activityName, String consumerName) {
        Page<TeacherGradeItemVO> page = new Page<>(index, PAGE_SIZE);
        return mapper.getTeacherGradePage(page, teacherId, activityName, consumerName).getRecords();
    }
}
