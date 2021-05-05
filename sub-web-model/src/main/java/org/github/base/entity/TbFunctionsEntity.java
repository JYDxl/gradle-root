package org.github.base.entity;

import org.github.base.Model;
import java.time.LocalDateTime;
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
 * @since 2021-05-05
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_functions")
@ApiModel(value="TbFunctionsEntity对象", description="")
public class TbFunctionsEntity extends Model<TbFunctionsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "func_id", type = IdType.AUTO)
  private @Nullable Integer funcId;

  @TableField("func_name")
  private @Nullable String funcName;

  @TableField("func_url")
  private @Nullable String funcUrl;

  @TableField("func_code")
  private @Nullable String funcCode;

  @TableField("parent_id")
  private @Nullable Integer parentId;

  @TableField("func_type")
  private @Nullable Integer funcType;

  @TableField("status")
  private @Nullable Integer status;

  @TableField("sort_num")
  private @Nullable Integer sortNum;

  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @TableField("update_time")
  private @Nullable LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.funcId;
  }

}
