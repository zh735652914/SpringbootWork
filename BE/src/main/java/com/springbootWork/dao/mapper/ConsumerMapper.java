package com.springbootWork.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.ConsumerInfoVO;
import com.springbootWork.model.vo.response.table.ConsumerItemVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerMapper extends BaseMapper<ConsumerEntity> {
    Integer getDepartmentIdById(Integer consumerId);

    Integer getGradeById(Integer consumerId);

    Integer count(String majorName, String className, String name);

    IPage<ConsumerItemVO> getPage(IPage<ConsumerItemVO> page, String majorName, String className, String name);

    ConsumerInfoVO getConsumerInfoById(Integer consumerId);
}
