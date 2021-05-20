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
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("admin_menu_auth")
@ApiModel(value="AdminMenuAuthEntity对象", description="")
public class AdminMenuAuthEntity extends Model<AdminMenuAuthEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  /** 如果该菜单为一级菜单，那么parent_guid为NULL */
  @ApiModelProperty(value = "如果该菜单为一级菜单，那么parent_guid为NULL")
  @TableField("controller")
  private @Nullable String controller;

  @TableField("action")
  private @Nullable String action;

  @TableField("name")
  private @Nullable String name;

  @TableField("classname")
  private @Nullable String classname;

  /** 0：禁用
            1：启用 */
  @ApiModelProperty(value = "0：禁用
            1：启用")
  @TableField("status")
  private @Nullable Integer status;

  @TableField("sort")
  private @Nullable Integer sort;

  /** 1：模块
            2：菜单
            3：权限 */
  @ApiModelProperty(value = "1：模块
            2：菜单
            3：权限")
  @TableField("type")
  private @Nullable Integer type;

  @TableField("parent_id")
  private @Nullable Integer parentId;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
