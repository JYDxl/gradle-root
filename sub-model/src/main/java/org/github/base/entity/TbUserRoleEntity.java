package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("tb_user_role")
@ApiModel(value="TbUserRoleEntity对象", description="")
public class TbUserRoleEntity extends Model<TbUserRoleEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.ASSIGN_ID)
  private Integer userId;

  @TableField("role_id")
  private Integer roleId;

  @Override
  protected Serializable pkVal() {
    return this.userId;
  }

}