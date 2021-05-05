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
 * @since 2021-05-05
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_role_function")
@ApiModel(value="TbRoleFunctionEntity对象", description="")
public class TbRoleFunctionEntity extends Model<TbRoleFunctionEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "role_id", type = IdType.ASSIGN_ID)
  private @Nullable Integer roleId;

  @TableField("func_id")
  private @Nullable Integer funcId;

  @Override
  protected Serializable pkVal() {
    return this.roleId;
  }

}
