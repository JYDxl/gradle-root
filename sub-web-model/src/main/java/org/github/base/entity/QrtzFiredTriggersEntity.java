package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.*;
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
 * @since 2021-05-08
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_fired_triggers")
@ApiModel(value="QrtzFiredTriggersEntity对象", description="")
public class QrtzFiredTriggersEntity extends Model<QrtzFiredTriggersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("ENTRY_ID")
  private @Nullable String entryId;

  @TableField("TRIGGER_NAME")
  private @Nullable String triggerName;

  @TableField("TRIGGER_GROUP")
  private @Nullable String triggerGroup;

  @TableField("INSTANCE_NAME")
  private @Nullable String instanceName;

  @TableField("FIRED_TIME")
  private @Nullable Long firedTime;

  @TableField("SCHED_TIME")
  private @Nullable Long schedTime;

  @TableField("PRIORITY")
  private @Nullable Integer priority;

  @TableField("STATE")
  private @Nullable String state;

  @TableField("JOB_NAME")
  private @Nullable String jobName;

  @TableField("JOB_GROUP")
  private @Nullable String jobGroup;

  @TableField("IS_NONCONCURRENT")
  private @Nullable String isNonconcurrent;

  @TableField("REQUESTS_RECOVERY")
  private @Nullable String requestsRecovery;

  @Override
  protected Serializable pkVal() {
    return this.schedName;
  }

}
