package org.github.mysql.web.base.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
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
 * @since 2021-05-21
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@ApiModel(value="SysUserEntity对象", description="系统用户")
public class SysUserEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.AUTO)
  private Long userId;

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  @TableField("username")
  private String username;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  @TableField("password")
  private String password;

  /** salt */
  @ApiModelProperty(value = "salt")
  @TableField("salt")
  private String salt;

  /** 状态  0：禁用 1：正常 */
  @ApiModelProperty(value = "状态  0：禁用 1：正常")
  @TableField("status")
  private Integer status;

  /** 邮箱 */
  @ApiModelProperty(value = "邮箱")
  @TableField("email")
  private String email;

  /** 手机号 */
  @ApiModelProperty(value = "手机号")
  @TableField("mobile")
  private String mobile;

  /** 创建者ID */
  @ApiModelProperty(value = "创建者ID")
  @TableField("create_user_id")
  private Long createUserId;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private LocalDateTime createTime;

  /** 0：未删除 1：已删除 */
  @ApiModelProperty(value = "0：未删除 1：已删除")
  @TableField("deleted")
  @TableLogic
  private Integer deleted;

}
