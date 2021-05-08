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
@TableName("dict_answer")
@ApiModel(value="DictAnswerEntity对象", description="")
public class DictAnswerEntity extends Model<DictAnswerEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("weight_id")
  private @Nullable Integer weightId;

  @TableField("name")
  private @Nullable String name;

  @TableField("en_name")
  private @Nullable String enName;

  @TableField("adjust_value")
  private @Nullable Integer adjustValue;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
