package com.springbootWork.service.admin;

import com.springbootWork.manager.admin.ConsumerManager;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import com.springbootWork.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService extends BaseService {
    private final ConsumerManager manager;
    private final UserService userService;

    public ConsumerService(ConsumerManager manager, UserService userService) {
        this.manager = manager;
        this.userService = userService;
    }

    public ResultVO getPageCount(String className, String name) {
        return result(manager.getPageCount(className, name));
    }

    public ResultVO getPage(Integer index, String name) {
        return result(manager.getPage(index, name));
    }

    public ResultVO get(Integer id) {
        ConsumerEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("用户Id: " + id + "不存在!");
        }

        entity.setPassword("");

        return result(entity);
    }

    public ResultVO update(ConsumerEntity entity) {
        ConsumerEntity origin = manager.get(entity.getId());
        if (origin == null) {
            return failedResult("用户Id: " + entity.getId() + "不存在!");
        }

        if (entity.getPassword().equals("")) {
            entity.setPassword(origin.getPassword());
        } else {
            entity.setPassword(userService.computePasswordHash(entity.getPassword()));
        }

        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        if (manager.get(id) == null) {
            return failedResult("用户Id: " + id + "不存在!");
        }
        if (manager.hasConsumerActivity(id)) {
            return failedResult("此用户还有未退选活动");
        }

        manager.delete(id);
        return result("删除成功");
    }

    public ResultVO create(ConsumerEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("用户Id: " + entity.getId() + "已存在!");
        }

        manager.create(entity);
        return result("添加成功");
    }

    public ResultVO listName() {
        return result(manager.listName());
    }
}
