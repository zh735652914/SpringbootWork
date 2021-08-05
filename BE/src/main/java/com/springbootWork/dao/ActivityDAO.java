package com.springbootWork.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootWork.dao.mapper.ActivityMapper;
import com.springbootWork.model.bo.ActivityItemBO;
import com.springbootWork.model.bo.ConsumerActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final ActivityMapper mapper;

    public ActivityDAO(ActivityMapper mapper) {
        this.mapper = mapper;
    }

    public int insert(ActivityEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public ActivityEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(ActivityEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String departmentName, String teacherName, String name) {
        return mapper.count(departmentName, teacherName, name);
    }

//    public int count(String teacherName, String name) {
//        return mapper.count(teacherName, name);
//    }

    public List<ActivityItemBO> getPage(Integer index, String departmentName, String teacherName, String name) {
        Page<ActivityItemBO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, departmentName, teacherName, name).getRecords();
    }

    public Integer countByTeacherId(Integer teacherId) {
        LambdaQueryWrapper<ActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ActivityEntity::getTeacherId, teacherId);

        return mapper.selectCount(wrapper);
    }

    public List<ActivityEntity> listName() {
        LambdaQueryWrapper<ActivityEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(ActivityEntity::getId, ActivityEntity::getName);

        return mapper.selectList(wrapper);
    }

    public int increaseSelectedCount(Integer activityId) {
        ActivityEntity activity = mapper.selectById(activityId);
        activity.setSelectedCount(activity.getSelectedCount() + 1);

        return mapper.updateById(activity);
    }

    public int decreaseSelectedCount(Integer activityId) {
        ActivityEntity activity = mapper.selectById(activityId);
        activity.setSelectedCount(activity.getSelectedCount() - 1);

        return mapper.updateById(activity);
    }

//    public Integer countConsumerCanSelect(Integer consumerId, Integer departmentId, Integer grade, String activityName, String teacherName) {
//        return mapper.countConsumerCanSelect(consumerId, departmentId, grade, activityName, teacherName);
//    }

    public Integer countConsumerCanSelect(Integer consumerId, Integer departmentId, Integer grade, String activityName, String teacherName) {
        return mapper.countConsumerCanSelect(consumerId, departmentId, grade, activityName, teacherName);
    }

    public List<ConsumerActivitySelectItemBO> getConsumerCanSelectPage(Integer index, Integer consumerId, Integer departmentId, Integer grade, String activityName, String teacherName) {
        Page<ConsumerActivitySelectItemBO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getConsumerCanSelectPage(page, consumerId, departmentId, grade, activityName, teacherName).getRecords();
    }

//    public List<ConsumerActivitySelectItemBO> getConsumerCanSelectPage(Integer index, Integer consumerId, String activityName, String teacherName) {
//        Page<ConsumerActivitySelectItemBO> page = new Page<>(index, PAGE_SIZE);
//
//        return mapper.getConsumerCanSelectPage(page, consumerId, activityName, teacherName).getRecords();
//    }

//    public Integer getDepartmentIdById(Integer activityId) {
//        return mapper.getDepartmentIdById(activityId);
//    }
}
