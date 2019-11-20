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
@TableName("qrtz_scheduler_state")
public class QrtzSchedulerStateEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId("sched_name")
    private String schedName;

    @TableField("instance_name")
    private String instanceName;

    @TableField("last_checkin_time")
    private Long lastCheckinTime;

    @TableField("checkin_interval")
    private Long checkinInterval;
}
