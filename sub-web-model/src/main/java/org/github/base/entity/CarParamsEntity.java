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
@TableName("car_params")
@ApiModel(value="CarParamsEntity对象", description="")
public class CarParamsEntity extends Model<CarParamsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("param_name")
  private @Nullable String paramName;

  @TableField("type_id")
  private @Nullable Integer typeId;

  @TableField("state")
  private @Nullable Integer state;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
