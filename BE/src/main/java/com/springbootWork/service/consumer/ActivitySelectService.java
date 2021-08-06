package com.springbootWork.service.consumer;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.consumer.ActivitySelectManager;
import com.springbootWork.model.bo.ConsumerActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.model.vo.response.table.ConsumerActivitySelectItemVO;
import com.springbootWork.service.BaseService;
import com.springbootWork.util.LessonTimeConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivitySelectService extends BaseService {
    private final ActivitySelectManager manager;
    private final OptionManager optionManager;
    private final LessonTimeConverter lessonTimeConverter;

    public ActivitySelectService(ActivitySelectManager manager, OptionManager optionManager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.optionManager = optionManager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO getPageCount(String activityName, String teacherName) {
        Integer consumerId = getUserId();
        return result(manager.getPageCount(consumerId, activityName, teacherName));
    }

    public ResultVO getPage(Integer index, String activityName, String teacherName) {
        Integer consumerId = getUserId();

        List<ConsumerActivitySelectItemBO> boList = manager.getPage(index, consumerId, activityName, teacherName);
        List<ConsumerActivitySelectItemVO> voList = new ArrayList<>(boList.size());

        for (ConsumerActivitySelectItemBO bo : boList) {
            ConsumerActivitySelectItemVO vo = new ConsumerActivitySelectItemVO();
            BeanUtils.copyProperties(bo, vo);
            vo.setTime(lessonTimeConverter.covertTimePart(bo.getTime()));
            voList.add(vo);
        }

        return result(voList);
    }

    public ResultVO create(Integer activityId) {
        Integer consumerId = getUserId();

        if (!optionManager.getAllowConsumerSelect()) {
            return failedResult("现在不是选择时间!");
        }
        ConsumerEntity consumer = manager.getConsumerById(consumerId);
        ActivityEntity activity = manager.getActivityById(activityId);
        if (consumer == null) {
            return failedResult("用户Id:" + consumerId + "不存在!");
        }
        if (activity == null) {
            return failedResult("活动Id:" + activityId + "不存在!");
        }
        if (activity.getSelectedCount() >= activity.getMaxSize()) {
            return failedResult("课容量已满!");
        }
        if (manager.getConsumerActivityByActivityIdAndConsumerId(activityId, consumerId) != null) {
            return failedResult("用户已选择此活动!");
        }
        String timePart = splitTimePart(activity.getTime());
        if (manager.countConsumerActivitySelectedByTimePart(consumerId, timePart) > 0) {
            return failedResult("活动时间冲突!");
        }

        ConsumerActivityEntity consumerActivity = new ConsumerActivityEntity();
        consumerActivity.setActivityId(activityId);
        consumerActivity.setConsumerId(consumerId);
        manager.create(consumerActivity);

        return result("选择成功");
    }

    private String splitTimePart(String time) {
        String[] spilt = time.split("-");
        return spilt[0] + "-" + spilt[1];
    }
}
