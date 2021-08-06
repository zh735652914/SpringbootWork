package com.springbootWork.service;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.VisitorManager;
import com.springbootWork.model.bo.ConsumerActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.model.vo.response.table.ConsumerActivitySelectItemVO;
import com.springbootWork.util.LessonTimeConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService extends BaseService {
    private final VisitorManager manager;
    private final OptionManager optionManager;
    private final LessonTimeConverter lessonTimeConverter;

    public VisitorService(VisitorManager manager, OptionManager optionManager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.optionManager = optionManager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO getPageCount(String activityName, String teacherName) {
        return result(manager.getPageCount( activityName, teacherName));
    }

    public ResultVO getPage(Integer index, String activityName, String teacherName) {

        List<ConsumerActivitySelectItemBO> boList = manager.getPage(index, activityName, teacherName);
        List<ConsumerActivitySelectItemVO> voList = new ArrayList<>(boList.size());

        for (ConsumerActivitySelectItemBO bo : boList) {
            ConsumerActivitySelectItemVO vo = new ConsumerActivitySelectItemVO();
            BeanUtils.copyProperties(bo, vo);
            vo.setTime(lessonTimeConverter.covertTimePart(bo.getTime()));
            voList.add(vo);
        }

        return result(voList);
    }

}
