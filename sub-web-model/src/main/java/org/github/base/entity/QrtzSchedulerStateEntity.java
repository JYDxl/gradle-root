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
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_scheduler_state")
@ApiModel(value="QrtzSchedulerStateEntity对象", description="")
public class QrtzSchedulerStateEntity extends Model<QrtzSchedulerStateEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("INSTANCE_NAME")
  private @Nullable String instanceName;

  @TableField("LAST_CHECKIN_TIME")
  private @Nullable Long lastCheckinTime;

  @TableField("CHECKIN_INTERVAL")
  private @Nullable Long checkinInterval;

  @Override
  protected Serializable pkVal() {
    return this.schedName;
  }

}
