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
 * @since 2021-05-08
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("admin_role")
@ApiModel(value="AdminRoleEntity对象", description="")
public class AdminRoleEntity extends Model<AdminRoleEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("name")
  private @Nullable String name;

  /** 0：未删除	            1：已删除 */
  @ApiModelProperty(value = "0：未删除	            1：已删除")
  @TableField("deleted")
  @TableLogic
  private @Nullable Integer deleted;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
