package org.github.mysql.web.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
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
 * @since 2021-05-22
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_role")
@ApiModel(value="SysUserRoleEntity对象", description="用户与角色对应关系")
public class SysUserRoleEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /** 用户ID */
  @ApiModelProperty(value = "用户ID")
  @TableField("user_id")
  private Long userId;

  /** 角色ID */
  @ApiModelProperty(value = "角色ID")
  @TableField("role_id")
  private Long roleId;

}
