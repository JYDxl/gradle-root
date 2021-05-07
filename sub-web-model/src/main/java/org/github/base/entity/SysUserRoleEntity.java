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
 * 用户与角色对应关系
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_role")
@ApiModel(value="SysUserRoleEntity对象", description="用户与角色对应关系")
public class SysUserRoleEntity extends Model<SysUserRoleEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  /** 用户ID */
  @ApiModelProperty(value = "用户ID")
  @TableField("user_id")
  private @Nullable Long userId;

  /** 角色ID */
  @ApiModelProperty(value = "角色ID")
  @TableField("role_id")
  private @Nullable Long roleId;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
