package com.springbootWork.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootWork.dao.mapper.TeacherMapper;
import com.springbootWork.model.entity.TeacherEntity;
import com.springbootWork.model.vo.response.table.TeacherActivityItemVO;
import com.springbootWork.model.vo.response.table.TeacherItemVO;
import com.springbootWork.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final TeacherMapper mapper;

    public TeacherDAO(TeacherMapper mapper) {
        this.mapper = mapper;
    }

    public int insert(TeacherEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public TeacherEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(TeacherEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String name) {
        return mapper.count(name);
    }

    public List<TeacherItemVO> getPage(Integer index, String name) {
        Page<TeacherItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, name).getRecords();
    }

    public TeacherEntity getByNumber(String number) {
        LambdaQueryWrapper<TeacherEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TeacherEntity::getNumber, number);

        return mapper.selectOne(wrapper);
    }

    public List<TeacherEntity> listName() {
        LambdaQueryWrapper<TeacherEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(TeacherEntity::getId, TeacherEntity::getName);

        return mapper.selectList(wrapper);
    }

    public List<TimetableItemVO> listTeacherTimetable(Integer teacherId) {
        return mapper.listTeacherTimetable(teacherId);
    }

    public List<TeacherActivityItemVO> listTeacherActivity(Integer teacherId) {
        return mapper.listTeacherActivity(teacherId);
    }
}
