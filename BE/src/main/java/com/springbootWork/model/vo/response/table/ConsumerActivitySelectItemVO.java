package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class ConsumerActivitySelectItemVO {
    private Integer activityId;
    private String activityName;
    private String teacherName;
    private Integer credit;
    private String time;
    private Integer selectedCount;
    private Integer maxSize;
}
