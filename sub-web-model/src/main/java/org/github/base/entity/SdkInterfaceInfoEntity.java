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
@TableName("sdk_interface_info")
@ApiModel(value="SdkInterfaceInfoEntity对象", description="")
public class SdkInterfaceInfoEntity extends Model<SdkInterfaceInfoEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  @TableField("cars_id")
  private @Nullable String carsId;

  @TableField("activity_key")
  private @Nullable String activityKey;

  @TableField("dealer")
  private @Nullable String dealer;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
