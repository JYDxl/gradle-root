package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.*;
import java.sql.Blob;
import java.io.Serializable;
import javax.annotation.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_triggers")
@ApiModel(value="QrtzTriggersEntity对象", description="")
public class QrtzTriggersEntity extends Model<QrtzTriggersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("TRIGGER_NAME")
  private @Nullable String triggerName;

  @TableField("TRIGGER_GROUP")
  private @Nullable String triggerGroup;

  @TableField("JOB_NAME")
  private @Nullable String jobName;

  @TableField("JOB_GROUP")
  private @Nullable String jobGroup;

  @TableField("DESCRIPTION")
  private @Nullable String description;

  @TableField("NEXT_FIRE_TIME")
  private @Nullable Long nextFireTime;

  @TableField("PREV_FIRE_TIME")
  private @Nullable Long prevFireTime;

  @TableField("PRIORITY")
  private @Nullable Integer priority;

  @TableField("TRIGGER_STATE")
  private @Nullable String triggerState;

  @TableField("TRIGGER_TYPE")
  private @Nullable String triggerType;

  @TableField("START_TIME")
  private @Nullable Long startTime;

  @TableField("END_TIME")
  private @Nullable Long endTime;

  @TableField("CALENDAR_NAME")
  private @Nullable String calendarName;

  @TableField("MISFIRE_INSTR")
  private @Nullable Integer misfireInstr;

  @TableField("JOB_DATA")
  private @Nullable Blob jobData;

  @Override
  public Serializable pkVal() {
    return this.schedName;
  }

}
