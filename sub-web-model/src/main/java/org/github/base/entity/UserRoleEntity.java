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
@TableName("user_role")
@ApiModel(value="UserRoleEntity对象", description="")
public class UserRoleEntity extends Model<UserRoleEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("user_id")
  private @Nullable Integer userId;

  @TableField("role_id")
  private @Nullable Integer roleId;

  @TableField("remarks")
  private @Nullable String remarks;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
