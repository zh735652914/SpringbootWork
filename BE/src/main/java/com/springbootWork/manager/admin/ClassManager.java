package com.springbootWork.manager.admin;

import com.springbootWork.dao.ClassDAO;
import com.springbootWork.dao.MajorDAO;
import com.springbootWork.dao.ConsumerDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ClassEntity;
import com.springbootWork.model.entity.MajorEntity;
import com.springbootWork.model.vo.response.IdNameVO;
import com.springbootWork.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassManager extends BaseManager {
    private final MajorDAO majorDAO;
    private final ClassDAO classDAO;
    private final ConsumerDAO consumerDAO;

    public ClassManager(MajorDAO majorDAO, ClassDAO classDAO, ConsumerDAO consumerDAO) {
        this.majorDAO = majorDAO;
        this.classDAO = classDAO;
        this.consumerDAO = consumerDAO;
    }

    public Integer getPageCount(String departmentName, String majorName, String name) {
        int count = classDAO.count(departmentName, majorName, name);
        return calcPageCount(count, ClassDAO.PAGE_SIZE);
    }

    public List<MajorItemVO> getPage(Integer index, String departmentName, String majorName, String name) {
        return classDAO.getPage(index, departmentName, majorName, name);
    }

    public ClassEntity get(Integer id) {
        return classDAO.get(id);
    }

    public int create(ClassEntity entity) {
        return classDAO.insert(entity);
    }

    public int update(ClassEntity entity) {
        return classDAO.update(entity);
    }

    public int delete(Integer id) {
        return classDAO.delete(id);
    }

    public MajorEntity getMajorById(Integer majorId) {
        return majorDAO.get(majorId);
    }

    public boolean hasConsumer(Integer classId) {
        return consumerDAO.countByClassId(classId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<ClassEntity> entityList = classDAO.listName();
        for (ClassEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
