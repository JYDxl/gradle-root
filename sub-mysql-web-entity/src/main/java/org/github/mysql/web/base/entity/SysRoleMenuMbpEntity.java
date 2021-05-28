package org.github.mysql.web.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
import javax.annotation.Nullable;
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
 * @since 2021-05-28
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu")
@ApiModel(value="SysRoleMenuMbpEntity对象", description="角色与菜单对应关系")
public class SysRoleMenuMbpEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  /** 角色ID */
  @ApiModelProperty(value = "角色ID")
  @TableField("role_id")
  private @Nullable Long roleId;

  /** 菜单ID */
  @ApiModelProperty(value = "菜单ID")
  @TableField("menu_id")
  private @Nullable Long menuId;

}
