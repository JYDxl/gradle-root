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
@TableName("qrtz_simple_triggers")
public class QrtzSimpleTriggersEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId(value = "sched_name", type = IdType.ASSIGN_UUID)
    private String schedName;

    @TableField("trigger_name")
    private String triggerName;

    @TableField("trigger_group")
    private String triggerGroup;

    @TableField("repeat_count")
    private Long repeatCount;

    @TableField("repeat_interval")
    private Long repeatInterval;

    @TableField("times_triggered")
    private Long timesTriggered;
}
