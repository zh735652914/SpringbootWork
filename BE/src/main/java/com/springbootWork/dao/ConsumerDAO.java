package com.springbootWork.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootWork.dao.mapper.ConsumerMapper;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.ConsumerInfoVO;
import com.springbootWork.model.vo.response.table.ConsumerItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsumerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final ConsumerMapper mapper;

    public ConsumerDAO(ConsumerMapper mapper) {
        this.mapper = mapper;
    }

    public ConsumerEntity getByNumber(String number) {
        LambdaQueryWrapper<ConsumerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ConsumerEntity::getNumber, number);

        return mapper.selectOne(wrapper);
    }


    public int insert(ConsumerEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public ConsumerEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(ConsumerEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String className, String name) {
        return mapper.count(className, name);
    }

    public List<ConsumerItemVO> getPage(Integer index, String name) {
        Page<ConsumerItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, name).getRecords();
    }

    public List<ConsumerEntity> listName() {
        LambdaQueryWrapper<ConsumerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(ConsumerEntity::getId, ConsumerEntity::getName);

        return mapper.selectList(wrapper);
    }

    public ConsumerInfoVO getConsumerInfoById(Integer consumerId) {
        return mapper.getConsumerInfoById(consumerId);
    }
}
