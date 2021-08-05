package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class ConsumerActivityItemVO {
    private Integer id;
    private String activityName;
    private String consumerName;
    private String className;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
}
