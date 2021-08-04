package com.springbootWork.manager.admin;

import com.springbootWork.dao.ClassDAO;
import com.springbootWork.dao.DepartmentDAO;
import com.springbootWork.dao.MajorDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.DepartmentEntity;
import com.springbootWork.model.entity.MajorEntity;
import com.springbootWork.model.vo.response.IdNameVO;
import com.springbootWork.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MajorManager extends BaseManager {
    private final MajorDAO majorDAO;
    private final DepartmentDAO departmentDAO;
    private final ClassDAO classDAO;

    public MajorManager(MajorDAO majorDAO, DepartmentDAO departmentDAO, ClassDAO classDAO) {
        this.majorDAO = majorDAO;
        this.departmentDAO = departmentDAO;
        this.classDAO = classDAO;
    }

    public Integer getPageCount(String departmentName, String name) {
        int count = majorDAO.count(departmentName, name);
        return calcPageCount(count, MajorDAO.PAGE_SIZE);
    }

    public List<MajorItemVO> getPage(Integer index, String departmentName, String name) {
        return majorDAO.getPage(index, departmentName, name);
    }

    public MajorEntity get(Integer id) {
        return majorDAO.get(id);
    }

    public int create(MajorEntity entity) {
        return majorDAO.insert(entity);
    }

    public int update(MajorEntity entity) {
        return majorDAO.update(entity);
    }

    public int delete(Integer id) {
        return majorDAO.delete(id);
    }

    public boolean hasClass(Integer majorId) {
        return classDAO.countByMajorId(majorId) > 0;
    }

    public DepartmentEntity getDepartmentById(Integer id) {
        return departmentDAO.get(id);
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<MajorEntity> entityList = majorDAO.listName();
        for (MajorEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
