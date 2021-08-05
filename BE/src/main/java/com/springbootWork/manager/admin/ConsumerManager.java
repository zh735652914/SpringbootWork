package com.springbootWork.manager.admin;

import com.springbootWork.dao.ClassDAO;
import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.dao.ConsumerDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ClassEntity;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.IdNameVO;
import com.springbootWork.model.vo.response.table.ConsumerItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumerManager extends BaseManager {
    private final ClassDAO classDAO;
    private final ConsumerActivityDAO consumerActivityDAO;
    private final ConsumerDAO consumerDAO;

    public ConsumerManager(ClassDAO classDAO, ConsumerActivityDAO consumerActivityDAO, ConsumerDAO consumerDAO) {
        this.classDAO = classDAO;
        this.consumerActivityDAO = consumerActivityDAO;
        this.consumerDAO = consumerDAO;
    }

    public Integer getPageCount(String majorName, String className, String name) {
        int count = consumerDAO.count(majorName, className, name);
        return calcPageCount(count, ConsumerDAO.PAGE_SIZE);
    }

    public List<ConsumerItemVO> getPage(Integer index, String majorName, String className, String name) {
        return consumerDAO.getPage(index, majorName, className, name);
    }

    public ConsumerEntity get(Integer id) {
        return consumerDAO.get(id);
    }

    public int create(ConsumerEntity entity) {
        return consumerDAO.insert(entity);
    }

    public int update(ConsumerEntity entity) {
        return consumerDAO.update(entity);
    }

    public int delete(Integer id) {
        return consumerDAO.delete(id);
    }

    public ClassEntity getClassById(Integer classId) {
        return classDAO.get(classId);
    }

    public boolean hasConsumerActivity(Integer consumerId) {
        return consumerActivityDAO.countByConsumerId(consumerId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<ConsumerEntity> entityList = consumerDAO.listName();
        for (ConsumerEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
