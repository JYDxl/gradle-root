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
@TableName("qrtz_paused_trigger_grps")
@ApiModel(value="QrtzPausedTriggerGrpsEntity对象", description="")
public class QrtzPausedTriggerGrpsEntity extends Model<QrtzPausedTriggerGrpsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("TRIGGER_GROUP")
  private @Nullable String triggerGroup;

  @Override
  public Serializable pkVal() {
    return this.schedName;
  }

}
