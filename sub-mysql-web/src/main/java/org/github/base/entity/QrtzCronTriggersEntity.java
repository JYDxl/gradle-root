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
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_cron_triggers")
@ApiModel(value="QrtzCronTriggersEntity对象", description="")
public class QrtzCronTriggersEntity extends Model<QrtzCronTriggersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("TRIGGER_NAME")
  private @Nullable String triggerName;

  @TableField("TRIGGER_GROUP")
  private @Nullable String triggerGroup;

  @TableField("CRON_EXPRESSION")
  private @Nullable String cronExpression;

  @TableField("TIME_ZONE_ID")
  private @Nullable String timeZoneId;

  @Override
  public Serializable pkVal() {
    return this.schedName;
  }

}
