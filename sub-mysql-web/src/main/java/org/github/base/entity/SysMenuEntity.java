package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-21
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
@ApiModel(value="SysMenuEntity对象", description="菜单管理")
public class SysMenuEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "menu_id", type = IdType.AUTO)
  private Long menuId;

  /** 父菜单ID，一级菜单为0 */
  @ApiModelProperty(value = "父菜单ID，一级菜单为0")
  @TableField("parent_id")
  private Long parentId;

  /** 菜单名称 */
  @ApiModelProperty(value = "菜单名称")
  @TableField("name")
  private String name;

  /** 菜单URL */
  @ApiModelProperty(value = "菜单URL")
  @TableField("url")
  private String url;

  /** 授权(多个用逗号分隔，如：user:list,user:create) */
  @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")
  @TableField("perms")
  private String perms;

  /** 类型   0：目录   1：菜单   2：按钮 */
  @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
  @TableField("type")
  private Integer type;

  /** 菜单图标 */
  @ApiModelProperty(value = "菜单图标")
  @TableField("icon")
  private String icon;

  /** 排序 */
  @ApiModelProperty(value = "排序")
  @TableField("order_num")
  private Integer orderNum;

  /** 是否启用（0：启用 1：禁用） */
  @ApiModelProperty(value = "是否启用（0：启用 1：禁用）")
  @TableField("enabled")
  private Integer enabled;

}
