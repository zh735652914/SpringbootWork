package com.springbootWork.model.bo;

import lombok.Data;

@Data
public class ActivityItemBO {
    private Integer id;
    private String name;
    private String teacherName;
    private String activityDescribe;
    private String time;
    private String activityLocation;
    private Integer selectedCount;
    private Integer maxSize;
}
