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
@TableName("activity_interface")
@ApiModel(value="ActivityInterfaceEntity对象", description="")
public class ActivityInterfaceEntity extends Model<ActivityInterfaceEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  @TableField("interface_id")
  private @Nullable Integer interfaceId;

  @TableField("sdk_id")
  private @Nullable Integer sdkId;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
