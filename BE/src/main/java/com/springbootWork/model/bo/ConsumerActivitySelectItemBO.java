package com.springbootWork.model.bo;

import lombok.Data;

@Data
public class ConsumerActivitySelectItemBO {
    private Integer activityId;
    private String activityName;
    private String teacherName;
    private String activityDescribe;
    private String time;
    private String activityLocation;
    private Integer selectedCount;
    private Integer maxSize;
}
