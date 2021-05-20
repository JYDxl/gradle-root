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
@TableName("admin_role_menu")
@ApiModel(value="AdminRoleMenuEntity对象", description="")
public class AdminRoleMenuEntity extends Model<AdminRoleMenuEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "role_id", type = IdType.ASSIGN_ID)
  private @Nullable Integer roleId;

  @TableField("menu_id")
  private @Nullable Integer menuId;

  @Override
  public Serializable pkVal() {
    return this.roleId;
  }

}
