package com.springbootWork.model.bo;

import lombok.Data;

@Data
public class ConsumerActivitySelectItemBO {
    private Integer activityId;
    private String activityName;
    private String teacherName;
    private Integer credit;
    private String time;
    private Integer selectedCount;
    private Integer maxSize;
}
