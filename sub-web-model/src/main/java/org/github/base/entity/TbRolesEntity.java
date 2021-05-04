package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_roles")
@ApiModel(value="TbRolesEntity对象", description="")
public class TbRolesEntity extends Model<TbRolesEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "role_id", type = IdType.AUTO)
  private @Nullable Integer roleId;

  @TableField("role_name")
  private @Nullable String roleName;

  @TableField("note")
  private @Nullable String note;

  @TableField("system")
  private @Nullable Boolean system;

  @TableField("status")
  private @Nullable Integer status;

  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @TableField("update_time")
  private @Nullable LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.roleId;
  }

}
