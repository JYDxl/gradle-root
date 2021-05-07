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
@TableName("activity_dealer")
@ApiModel(value="ActivityDealerEntity对象", description="")
public class ActivityDealerEntity extends Model<ActivityDealerEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  /** 对应car_model表的id字段 */
  @ApiModelProperty(value = "对应car_model表的id字段")
  @TableField("dealer_id")
  private @Nullable Integer dealerId;

  @TableField("dealer_province")
  private @Nullable String dealerProvince;

  @TableField("dealer_city")
  private @Nullable String dealerCity;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
