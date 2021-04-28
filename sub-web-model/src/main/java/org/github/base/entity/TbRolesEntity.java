package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_roles")
@ApiModel(value="TbRolesEntity对象", description="")
public class TbRolesEntity extends Model<TbRolesEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "role_id", type = IdType.AUTO)
  private Integer roleId;

  @TableField("role_name")
  private String roleName;

  @TableField("note")
  private String note;

  @TableField("system")
  private Boolean system;

  @TableField("status")
  private Integer status;

  @TableField("create_time")
  private LocalDateTime createTime;

  @TableField("update_time")
  private LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.roleId;
  }

}
