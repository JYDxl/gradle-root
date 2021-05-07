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
@TableName("admin_user_role")
@ApiModel(value="AdminUserRoleEntity对象", description="")
public class AdminUserRoleEntity extends Model<AdminUserRoleEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  /** 如果该菜单为一级菜单，那么parent_guid为NULL */
  @ApiModelProperty(value = "如果该菜单为一级菜单，那么parent_guid为NULL")
  @TableField("user_id")
  private @Nullable Integer userId;

  @TableField("role_id")
  private @Nullable Integer roleId;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
