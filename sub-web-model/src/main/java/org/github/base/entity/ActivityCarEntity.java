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
@TableName("activity_car")
@ApiModel(value="ActivityCarEntity对象", description="")
public class ActivityCarEntity extends Model<ActivityCarEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("activity_id")
  private @Nullable Long activityId;

  /** 对应car_model表的id字段 */
  @ApiModelProperty(value = "对应car_model表的id字段")
  @TableField("car_id")
  private @Nullable Long carId;

  @TableField("enable")
  private @Nullable Integer enable;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
