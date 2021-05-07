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
@TableName("dict_weight")
@ApiModel(value="DictWeightEntity对象", description="")
public class DictWeightEntity extends Model<DictWeightEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("code")
  private @Nullable String code;

  @TableField("name")
  private @Nullable String name;

  @TableField("en_name")
  private @Nullable String enName;

  @TableField("weight")
  private @Nullable Integer weight;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
