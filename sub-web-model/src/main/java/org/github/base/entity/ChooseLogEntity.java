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
@TableName("choose_log")
@ApiModel(value="ChooseLogEntity对象", description="")
public class ChooseLogEntity extends Model<ChooseLogEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("member_id")
  private @Nullable String memberId;

  @TableField("user_country")
  private @Nullable Integer userCountry;

  @TableField("user_space")
  private @Nullable String userSpace;

  @TableField("user_power")
  private @Nullable String userPower;

  /** 关联car_model表的ID字段 */
  @ApiModelProperty(value = "关联car_model表的ID字段")
  @TableField("user_comfort")
  private @Nullable String userComfort;

  @TableField("user_safe")
  private @Nullable String userSafe;

  @TableField("user_cost")
  private @Nullable String userCost;

  @TableField("user_min")
  private @Nullable String userMin;

  @TableField("user_max")
  private @Nullable String userMax;

  @TableField("user_ptime")
  private @Nullable String userPtime;

  @TableField("user_car")
  private @Nullable String userCar;

  @TableField("choose_car")
  private @Nullable String chooseCar;

  @TableField("create_time")
  private @Nullable Long createTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
