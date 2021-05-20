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
@TableName("sdk_interface_type")
@ApiModel(value="SdkInterfaceTypeEntity对象", description="")
public class SdkInterfaceTypeEntity extends Model<SdkInterfaceTypeEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("type_id")
  private @Nullable String typeId;

  @TableField("interface_count")
  private @Nullable Integer interfaceCount;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
