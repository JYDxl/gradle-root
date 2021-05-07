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
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("car_select_list")
@ApiModel(value="CarSelectListEntity对象", description="")
public class CarSelectListEntity extends Model<CarSelectListEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("type")
  private @Nullable String type;

  @TableField("country")
  private @Nullable String country;

  @TableField("car_type")
  private @Nullable String carType;

  @TableField("car_type_bak")
  private @Nullable Boolean carTypeBak;

  /** 关联car_model表的ID字段 */
  @ApiModelProperty(value = "关联car_model表的ID字段")
  @TableField("msrp_min")
  private @Nullable BigDecimal msrpMin;

  @TableField("msrp_max")
  private @Nullable BigDecimal msrpMax;

  /** 所属车系 ：自主1 日2 韩3 德4 美5 欧6 */
  @ApiModelProperty(value = "所属车系 ：自主1 日2 韩3 德4 美5 欧6")
  @TableField("country_type")
  private @Nullable Boolean countryType;

  @TableField("country_std")
  private @Nullable Boolean countryStd;

  @TableField("space_std")
  private @Nullable BigDecimal spaceStd;

  @TableField("power_std")
  private @Nullable BigDecimal powerStd;

  @TableField("comfort_std")
  private @Nullable BigDecimal comfortStd;

  @TableField("cost_std")
  private @Nullable BigDecimal costStd;

  @TableField("safe_std")
  private @Nullable BigDecimal safeStd;

  @TableField("car_id")
  private @Nullable Integer carId;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
