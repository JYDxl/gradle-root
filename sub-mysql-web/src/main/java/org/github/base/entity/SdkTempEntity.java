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
@TableName("sdk_temp")
@ApiModel(value="SdkTempEntity对象", description="")
public class SdkTempEntity extends Model<SdkTempEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  @TableField("sdk_path")
  private @Nullable String sdkPath;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("sdk_name")
  private @Nullable String sdkName;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
