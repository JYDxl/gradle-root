package org.github.base.entity;

import org.github.base.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import javax.annotation.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@ApiModel(value="SysUserEntity对象", description="系统用户")
public class SysUserEntity extends Model<SysUserEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.AUTO)
  private @Nullable Long userId;

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  @TableField("username")
  private @Nullable String username;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  @TableField("password")
  private @Nullable String password;

  /** 邮箱 */
  @ApiModelProperty(value = "邮箱")
  @TableField("email")
  private @Nullable String email;

  /** 手机号 */
  @ApiModelProperty(value = "手机号")
  @TableField("mobile")
  private @Nullable String mobile;

  /** 状态  0：禁用   1：正常 */
  @ApiModelProperty(value = "状态  0：禁用   1：正常")
  @TableField("status")
  private @Nullable Integer status;

  /** 创建者ID */
  @ApiModelProperty(value = "创建者ID")
  @TableField("create_user_id")
  private @Nullable Long createUserId;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @Override
  protected Serializable pkVal() {
    return this.userId;
  }

}
