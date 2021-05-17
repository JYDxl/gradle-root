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
 * 菜单管理
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-17
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
@ApiModel(value="SysMenuEntity对象", description="菜单管理")
public class SysMenuEntity extends Model<SysMenuEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "menu_id", type = IdType.AUTO)
  private @Nullable Long menuId;

  /** 父菜单ID，一级菜单为0 */
  @ApiModelProperty(value = "父菜单ID，一级菜单为0")
  @TableField("parent_id")
  private @Nullable Long parentId;

  /** 菜单名称 */
  @ApiModelProperty(value = "菜单名称")
  @TableField("name")
  private @Nullable String name;

  /** 菜单URL */
  @ApiModelProperty(value = "菜单URL")
  @TableField("url")
  private @Nullable String url;

  /** 授权(多个用逗号分隔，如：user:list,user:create) */
  @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")
  @TableField("perms")
  private @Nullable String perms;

  /** 类型   0：目录   1：菜单   2：按钮 */
  @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
  @TableField("type")
  private @Nullable Integer type;

  /** 菜单图标 */
  @ApiModelProperty(value = "菜单图标")
  @TableField("icon")
  private @Nullable String icon;

  /** 排序 */
  @ApiModelProperty(value = "排序")
  @TableField("order_num")
  private @Nullable Integer orderNum;

  /** 是否启用（0：启用 1：禁用） */
  @ApiModelProperty(value = "是否启用（0：启用 1：禁用）")
  @TableField("enabled")
  private @Nullable Integer enabled;

  @Override
  public Serializable pkVal() {
    return this.menuId;
  }

}
