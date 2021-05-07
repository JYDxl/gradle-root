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
@TableName("dict_model")
@ApiModel(value="DictModelEntity对象", description="")
public class DictModelEntity extends Model<DictModelEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("code")
  private @Nullable String code;

  @TableField("country")
  private @Nullable String country;

  @TableField("model_name")
  private @Nullable String modelName;

  /** 关联car_model表的ID字段 */
  @ApiModelProperty(value = "关联car_model表的ID字段")
  @TableField("model_id")
  private @Nullable Integer modelId;

  @TableField("msrp_min")
  private @Nullable Integer msrpMin;

  @TableField("space")
  private @Nullable Integer space;

  @TableField("power")
  private @Nullable Integer power;

  @TableField("comfort")
  private @Nullable Integer comfort;

  @TableField("cost")
  private @Nullable Integer cost;

  @TableField("safety")
  private @Nullable Integer safety;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
