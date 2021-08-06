package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class ConsumerActivitySelectItemVO {
    private Integer activityId;
    private String activityName;
    private String teacherName;
    private String activityDescribe;
    private String time;
    private String activityLocation;
    private Integer selectedCount;
    private Integer maxSize;
}
