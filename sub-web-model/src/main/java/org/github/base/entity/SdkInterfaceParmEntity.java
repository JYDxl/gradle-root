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
@TableName("sdk_interface_parm")
@ApiModel(value="SdkInterfaceParmEntity对象", description="")
public class SdkInterfaceParmEntity extends Model<SdkInterfaceParmEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

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

  @TableField("is_required")
  private @Nullable Integer isRequired;

  @TableField("is_custom")
  private @Nullable Integer isCustom;

  @TableField("is_login")
  private @Nullable Integer isLogin;

  @TableField("activity_key")
  private @Nullable Integer activityKey;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
