package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("qrtz_fired_triggers")
public class QrtzFiredTriggersEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId(value = "sched_name", type = IdType.ASSIGN_UUID)
    private String schedName;

    @TableField("entry_id")
    private String entryId;

    @TableField("trigger_name")
    private String triggerName;

    @TableField("trigger_group")
    private String triggerGroup;

    @TableField("instance_name")
    private String instanceName;

    @TableField("fired_time")
    private Long firedTime;

    @TableField("sched_time")
    private Long schedTime;

    @TableField("priority")
    private Integer priority;

    @TableField("state")
    private String state;

    @TableField("job_name")
    private String jobName;

    @TableField("job_group")
    private String jobGroup;

    @TableField("is_nonconcurrent")
    private String isNonconcurrent;

    @TableField("requests_recovery")
    private String requestsRecovery;
}
