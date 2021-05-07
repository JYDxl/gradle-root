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
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("admin_user")
@ApiModel(value="AdminUserEntity对象", description="")
public class AdminUserEntity extends Model<AdminUserEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("username")
  private @Nullable String username;

  @TableField("password")
  private @Nullable String password;

  @TableField("name")
  private @Nullable String name;

  @TableField("salt")
  private @Nullable String salt;

  @TableField("phone")
  private @Nullable String phone;

  @TableField("email")
  private @Nullable String email;

  /** 0：未启用	            1：启用 */
  @ApiModelProperty(value = "0：未启用	            1：启用")
  @TableField("status")
  private @Nullable Integer status;

  @TableField("create_time")
  private @Nullable Long createTime;

  /** 0：普通管理员	            1：超级管理员 */
  @ApiModelProperty(value = "0：普通管理员	            1：超级管理员")
  @TableField("is_super")
  private @Nullable Integer isSuper;

  @TableField("consumer")
  private @Nullable String consumer;

  @TableField("remark")
  private @Nullable String remark;

  @TableField("dept")
  private @Nullable String dept;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
