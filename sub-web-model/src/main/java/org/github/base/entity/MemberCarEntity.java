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
@TableName("member_car")
@ApiModel(value="MemberCarEntity对象", description="")
public class MemberCarEntity extends Model<MemberCarEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("member_id")
  private @Nullable Long memberId;

  @TableField("brand_id")
  private @Nullable Integer brandId;

  @TableField("make_id")
  private @Nullable Integer makeId;

  @TableField("model_id")
  private @Nullable Integer modelId;

  @TableField("car_id")
  private @Nullable Integer carId;

  @TableField("buy_year")
  private @Nullable Integer buyYear;

  @TableField("current_mileage")
  private @Nullable Integer currentMileage;

  @TableField("remark")
  private @Nullable String remark;

  /** 1：已有座驾	            2：期望座驾 */
  @ApiModelProperty(value = "1：已有座驾	            2：期望座驾")
  @TableField("type")
  private @Nullable Integer type;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("last_update_time")
  private @Nullable Long lastUpdateTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
