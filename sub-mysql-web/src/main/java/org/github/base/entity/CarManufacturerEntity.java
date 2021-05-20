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
@TableName("car_manufacturer")
@ApiModel(value="CarManufacturerEntity对象", description="")
public class CarManufacturerEntity extends Model<CarManufacturerEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("manufacturer_name")
  private @Nullable String manufacturerName;

  @TableField("make_id")
  private @Nullable Integer makeId;

  @TableField("create_time")
  private @Nullable Long createTime;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
