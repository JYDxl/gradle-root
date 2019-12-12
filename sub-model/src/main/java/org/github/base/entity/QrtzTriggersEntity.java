package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_triggers")
public class QrtzTriggersEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId(value = "sched_name", type = IdType.ASSIGN_UUID)
    private String schedName;

    @TableField("trigger_name")
    private String triggerName;

    @TableField("trigger_group")
    private String triggerGroup;

    @TableField("job_name")
    private String jobName;

    @TableField("job_group")
    private String jobGroup;

    @TableField("description")
    private String description;

    @TableField("next_fire_time")
    private Long nextFireTime;

    @TableField("prev_fire_time")
    private Long prevFireTime;

    @TableField("priority")
    private Integer priority;

    @TableField("trigger_state")
    private String triggerState;

    @TableField("trigger_type")
    private String triggerType;

    @TableField("start_time")
    private Long startTime;

    @TableField("end_time")
    private Long endTime;

    @TableField("calendar_name")
    private String calendarName;

    @TableField("misfire_instr")
    private Integer misfireInstr;

    @TableField("job_data")
    private Blob jobData;
}
