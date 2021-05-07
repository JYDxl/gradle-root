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
@TableName("product")
@ApiModel(value="ProductEntity对象", description="")
public class ProductEntity extends Model<ProductEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("name")
  private @Nullable String name;

  @TableField("description")
  private @Nullable String description;

  @TableField("service")
  private @Nullable String service;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("update_time")
  private @Nullable Long updateTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
