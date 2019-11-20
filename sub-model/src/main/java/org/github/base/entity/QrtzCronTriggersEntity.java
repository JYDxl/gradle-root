package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2019-11-20
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_cron_triggers")
public class QrtzCronTriggersEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId("sched_name")
    private String schedName;

    @TableField("trigger_name")
    private String triggerName;

    @TableField("trigger_group")
    private String triggerGroup;

    @TableField("cron_expression")
    private String cronExpression;

    @TableField("time_zone_id")
    private String timeZoneId;
}
