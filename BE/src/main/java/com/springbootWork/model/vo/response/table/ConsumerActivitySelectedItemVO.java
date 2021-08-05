package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class ConsumerActivitySelectedItemVO {
    private Integer consumerActivityId;
    private String activityName;
    private String teacherName;
    private Integer credit;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
}
