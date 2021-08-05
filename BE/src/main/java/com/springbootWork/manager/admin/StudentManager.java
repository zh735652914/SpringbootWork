package com.springbootWork.manager.admin;

import com.springbootWork.dao.ClassDAO;
import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.dao.StudentDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ClassEntity;
import com.springbootWork.model.entity.StudentEntity;
import com.springbootWork.model.vo.response.IdNameVO;
import com.springbootWork.model.vo.response.table.StudentItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentManager extends BaseManager {
    private final ClassDAO classDAO;
    private final StudentActivityDAO studentActivityDAO;
    private final StudentDAO studentDAO;

    public StudentManager(ClassDAO classDAO, StudentActivityDAO studentActivityDAO, StudentDAO studentDAO) {
        this.classDAO = classDAO;
        this.studentActivityDAO = studentActivityDAO;
        this.studentDAO = studentDAO;
    }

    public Integer getPageCount(String majorName, String className, String name) {
        int count = studentDAO.count(majorName, className, name);
        return calcPageCount(count, StudentDAO.PAGE_SIZE);
    }

    public List<StudentItemVO> getPage(Integer index, String majorName, String className, String name) {
        return studentDAO.getPage(index, majorName, className, name);
    }

    public StudentEntity get(Integer id) {
        return studentDAO.get(id);
    }

    public int create(StudentEntity entity) {
        return studentDAO.insert(entity);
    }

    public int update(StudentEntity entity) {
        return studentDAO.update(entity);
    }

    public int delete(Integer id) {
        return studentDAO.delete(id);
    }

    public ClassEntity getClassById(Integer classId) {
        return classDAO.get(classId);
    }

    public boolean hasStudentActivity(Integer studentId) {
        return studentActivityDAO.countByStudentId(studentId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<StudentEntity> entityList = studentDAO.listName();
        for (StudentEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
