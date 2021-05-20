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
@TableName("product_car_activity")
@ApiModel(value="ProductCarActivityEntity对象", description="")
public class ProductCarActivityEntity extends Model<ProductCarActivityEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("product_id")
  private @Nullable Integer productId;

  @TableField("car_id")
  private @Nullable Integer carId;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
