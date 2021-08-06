package com.springbootWork.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootWork.model.bo.ActivityItemBO;
import com.springbootWork.model.bo.ConsumerActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapper extends BaseMapper<ActivityEntity> {
    Integer count(String teacherName, String name);

    IPage<ActivityItemBO> getPage(IPage<ActivityItemBO> page, String teacherName, String name);

    Integer countConsumerCanSelect(Integer consumerId, String activityName, String teacherName);

    IPage<ConsumerActivitySelectItemBO> getConsumerCanSelectPage(IPage<ConsumerActivitySelectItemBO> page, Integer consumerId, String activityName, String teacherName);

    Integer countVisitorCanSelect(String activityName, String teacherName);

    IPage<ConsumerActivitySelectItemBO> getVisitorCanSelectPage(IPage<ConsumerActivitySelectItemBO> page, String activityName, String teacherName);
}
