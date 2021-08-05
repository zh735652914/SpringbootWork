package com.springbootWork.service.admin;

import com.springbootWork.manager.admin.ConsumerActivityManager;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerActivityService extends BaseService {
    private final ConsumerActivityManager manager;

    public ConsumerActivityService(ConsumerActivityManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(String className, String activityName, String consumerName) {
        return result(manager.getPageCount(className, activityName, consumerName));
    }

    public ResultVO getPage(Integer index, String className, String activityName, String consumerName) {
        return result(manager.getPage(index, className, activityName, consumerName));
    }

    public ResultVO get(Integer id) {
        ConsumerActivityEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("用户选课Id: " + id + "不存在!");
        }

        return result(entity);
    }

    public ResultVO update(ConsumerActivityEntity entity) {
        ConsumerActivityEntity originEntity = manager.get(entity.getId());
        if (originEntity == null) {
            return failedResult("用户选课Id: " + entity.getId() + "不存在!");
        }
        if (!originEntity.getActivityId().equals(entity.getActivityId())) {
            return failedResult("活动Id被篡改");
        }
        if (!originEntity.getConsumerId().equals(entity.getConsumerId())) {
            return failedResult("用户Id被篡改");
        }

        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        ConsumerActivityEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("用户选课Id: " + id + "不存在!");
        }

        manager.delete(entity);
        return result("删除成功");
    }

    public ResultVO create(ConsumerActivityEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("用户选课Id: " + entity.getId() + "已存在!");
        }
        if (manager.getConsumerById(entity.getConsumerId()) == null) {
            return failedResult("所属用户Id: " + entity.getConsumerId() + "不存在!");
        }
        if (manager.getByActivityIdAndConsumerId(entity.getActivityId(), entity.getConsumerId()) != null) {
            return failedResult("用户已经选修此活动");
        }
        ActivityEntity activity = manager.getActivityById(entity.getActivityId());
        if (activity == null) {
            return failedResult("所属活动Id: " + entity.getActivityId() + "不存在!");
        }
        if (activity.getSelectedCount() >= activity.getMaxSize()) {
            return failedResult("课容量已满");
        }

        manager.create(entity);
        return result("添加成功");
    }
}
