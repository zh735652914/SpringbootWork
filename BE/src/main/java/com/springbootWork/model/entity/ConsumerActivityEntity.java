package com.springbootWork.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


@TableName("rc_consumer_activity")
@Data
public class ConsumerActivityEntity {
    public static final String ID = "sc_id";
    public static final String CONSUMER_ID = "sc_consumer_id";
    public static final String ACTIVITY_ID = "sc_activity_id";
    public static final String DAILY_SCORE = "sc_daily_score";
    public static final String EXAM_SCORE = "sc_exam_score";
    public static final String SCORE = "sc_score";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择学生")
    @TableField(CONSUMER_ID)
    private Integer consumerId;

    @NotNull(message = "必须选择活动")
    @TableField(ACTIVITY_ID)
    private Integer activityId;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    @TableField(value = DAILY_SCORE, updateStrategy = FieldStrategy.IGNORED)
    private Integer dailyScore;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    @TableField(value = EXAM_SCORE, updateStrategy = FieldStrategy.IGNORED)
    private Integer examScore;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    @TableField(value = SCORE, updateStrategy = FieldStrategy.IGNORED)
    private Integer score;
}
