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
@TableName("sdk_interface")
@ApiModel(value="SdkInterfaceEntity对象", description="")
public class SdkInterfaceEntity extends Model<SdkInterfaceEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("type_id")
  private @Nullable Integer typeId;

  @TableField("name")
  private @Nullable String name;

  @TableField("inter_desc")
  private @Nullable String interDesc;

  @TableField("url")
  private @Nullable String url;

  @TableField("success")
  private @Nullable String success;

  @TableField("error")
  private @Nullable String error;

  @TableField("request_type")
  private @Nullable String requestType;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
