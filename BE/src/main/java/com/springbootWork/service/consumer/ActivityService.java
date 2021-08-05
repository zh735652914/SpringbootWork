package com.springbootWork.service.consumer;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.consumer.ActivityManager;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service("consumer_activityService")
public class ActivityService extends BaseService {
    private final ActivityManager manager;
    private final OptionManager optionManager;

    public ActivityService(ActivityManager manager, OptionManager optionManager) {
        this.manager = manager;
        this.optionManager = optionManager;
    }

    public ResultVO list() {
        Integer consumerId = getUserId();
        return result(manager.listConsumerActivitySelected(consumerId));
    }

    public ResultVO delete(Integer consumerActivityId) {
        Integer consumerId = getUserId();
        if (!optionManager.getAllowConsumerSelect()) {
            return failedResult("现在不是选课退课时间!");
        }
        ConsumerActivityEntity consumerActivity = manager.getConsumerActivityById(consumerActivityId);
        if (consumerActivity == null) {
            return failedResult("学生选课Id:" + consumerActivityId + "不存在");
        }
        if (!consumerActivity.getConsumerId().equals(consumerId)) {
            return failedResult("此活动非此学生所选!");
        }
        if (consumerActivity.getDailyScore() != null || consumerActivity.getExamScore() != null || consumerActivity.getScore() != null) {
            return failedResult("学生已获得成绩, 不能退选");
        }

        manager.deleteConsumerActivity(consumerActivity);
        return result("退选成功");
    }
}
