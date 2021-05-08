package org.github.base.entity;

import org.github.base.Model;
import java.math.BigDecimal;
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
@TableName("qrtz_simprop_triggers")
@ApiModel(value="QrtzSimpropTriggersEntity对象", description="")
public class QrtzSimpropTriggersEntity extends Model<QrtzSimpropTriggersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("TRIGGER_NAME")
  private @Nullable String triggerName;

  @TableField("TRIGGER_GROUP")
  private @Nullable String triggerGroup;

  @TableField("STR_PROP_1")
  private @Nullable String strProp1;

  @TableField("STR_PROP_2")
  private @Nullable String strProp2;

  @TableField("STR_PROP_3")
  private @Nullable String strProp3;

  @TableField("INT_PROP_1")
  private @Nullable Integer intProp1;

  @TableField("INT_PROP_2")
  private @Nullable Integer intProp2;

  @TableField("LONG_PROP_1")
  private @Nullable Long longProp1;

  @TableField("LONG_PROP_2")
  private @Nullable Long longProp2;

  @TableField("DEC_PROP_1")
  private @Nullable BigDecimal decProp1;

  @TableField("DEC_PROP_2")
  private @Nullable BigDecimal decProp2;

  @TableField("BOOL_PROP_1")
  private @Nullable String boolProp1;

  @TableField("BOOL_PROP_2")
  private @Nullable String boolProp2;

  @Override
  protected Serializable pkVal() {
    return this.schedName;
  }

}
