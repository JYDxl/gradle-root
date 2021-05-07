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
@TableName("sdk_interface_udparm")
@ApiModel(value="SdkInterfaceUdparmEntity对象", description="")
public class SdkInterfaceUdparmEntity extends Model<SdkInterfaceUdparmEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  @TableField("interface_id")
  private @Nullable Integer interfaceId;

  @TableField("name")
  private @Nullable String name;

  @TableField("parm_name")
  private @Nullable String parmName;

  @TableField("data_type")
  private @Nullable Integer dataType;

  @TableField("description")
  private @Nullable String description;

  /** 关联car_product表的ID */
  @ApiModelProperty(value = "关联car_product表的ID")
  @TableField("product_id")
  private @Nullable Integer productId;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
