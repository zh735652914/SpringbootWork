package com.springbootWork.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@TableName("rc_activity")
@Data
public class ActivityEntity {
    public static final String ID = "activity_id";
    public static final String TEACHER_ID = "activity_teacher_id";
    public static final String NAME = "activity_name";
    public static final String TIME = "activity_time";
    public static final String LOCATION = "activity_location";
    public static final String DESCRIBE = "activity_describe";
    public static final String TYPE = "activity_type";
    public static final String SELECTED_COUNT = "activity_selected_count";
    public static final String MAX_SIZE = "activity_max_size";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择发起人")
    @TableField(TEACHER_ID)
    private Integer teacherId;

    @NotBlank(message = "活动名不能为空")
    @TableField(NAME)
    private String name;

    @Pattern(regexp = "[1-7]-[1-9]-[1-4]", message = "活动最长时间为4节")
    @TableField(TIME)
    private String time;

    @NotBlank(message = "活动描述不能为空")
    @TableField(DESCRIBE)
    private String activityDescribe;

    @NotBlank(message = "活动地点不能为空")
    @TableField(LOCATION)
    private String activityLocation;

    @TableField(SELECTED_COUNT)
    private Integer selectedCount;

    @NotNull
    @Range(min = 0, message = "容量不能为负数")
    @TableField(MAX_SIZE)
    private Integer maxSize;
}
