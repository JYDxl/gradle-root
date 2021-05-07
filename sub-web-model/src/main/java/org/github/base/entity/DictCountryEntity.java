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
@TableName("dict_country")
@ApiModel(value="DictCountryEntity对象", description="")
public class DictCountryEntity extends Model<DictCountryEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("name")
  private @Nullable String name;

  @TableField("en_name")
  private @Nullable String enName;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
