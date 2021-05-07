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
@TableName("dict_brand_point")
@ApiModel(value="DictBrandPointEntity对象", description="")
public class DictBrandPointEntity extends Model<DictBrandPointEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  /** 关联car_brand表的ID字段 */
  @ApiModelProperty(value = "关联car_brand表的ID字段")
  @TableField("brand_id")
  private @Nullable Integer brandId;

  @TableField("name")
  private @Nullable String name;

  @TableField("point")
  private @Nullable Integer point;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
