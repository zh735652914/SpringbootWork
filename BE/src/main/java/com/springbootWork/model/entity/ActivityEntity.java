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
    public static final String GRADE = "activity_grade";
    public static final String TIME = "activity_time";
    public static final String LOCATION = "activity_location";
    public static final String CREDIT = "activity_credit";
    public static final String TYPE = "activity_type";
    public static final String SELECTED_COUNT = "activity_selected_count";
    public static final String MAX_SIZE = "activity_max_size";
    public static final String EXAM_DATE = "activity_exam_date";
    public static final String EXAM_LOCATION = "activity_exam_location";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择授课教师")
    @TableField(TEACHER_ID)
    private Integer teacherId;

    @NotBlank(message = "活动名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @Range(min = 1980, max = 2999, message = "年级范围必须在1980-2999之间")
    @TableField(GRADE)
    private Integer grade;

    @Pattern(regexp = "[1-7]-[1-9]-[1-4]", message = "活动最长时间为4节")
    @TableField(TIME)
    private String time;

    @NotBlank(message = "上课地点不能为空")
    @TableField(LOCATION)
    private String location;

    @NotNull
    @Range(min = 1, max = 20, message = "学分必须在1-20之间")
    @TableField(CREDIT)
    private Integer credit;

    @TableField(SELECTED_COUNT)
    private Integer selectedCount;

    @NotNull
    @Range(min = 0, message = "容量不能为负数")
    @TableField(MAX_SIZE)
    private Integer maxSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField(value = EXAM_DATE, updateStrategy = FieldStrategy.IGNORED)
    private Date examDate;

    @TableField(value = EXAM_LOCATION, updateStrategy = FieldStrategy.IGNORED)
    private String examLocation;
}
