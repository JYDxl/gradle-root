package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色与菜单对应关系
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-21
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu")
@ApiModel(value="SysRoleMenuEntity对象", description="角色与菜单对应关系")
public class SysRoleMenuEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /** 角色ID */
  @ApiModelProperty(value = "角色ID")
  @TableField("role_id")
  private Long roleId;

  /** 菜单ID */
  @ApiModelProperty(value = "菜单ID")
  @TableField("menu_id")
  private Long menuId;

}
