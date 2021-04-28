package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * 用户表 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("users")
@ApiModel(value="UsersEntity对象", description="用户表 ")
public class UsersEntity extends Model<UsersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 主键id 用户id */
  @ApiModelProperty(value = "主键id 用户id")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 用户名 用户名 */
  @ApiModelProperty(value = "用户名 用户名")
  @TableField("username")
  private String username;

  /** 密码 密码 */
  @ApiModelProperty(value = "密码 密码")
  @TableField("password")
  private String password;

  /** 昵称 昵称 */
  @ApiModelProperty(value = "昵称 昵称")
  @TableField("nickname")
  private String nickname;

  /** 真实姓名 */
  @ApiModelProperty(value = "真实姓名")
  @TableField("realname")
  private String realname;

  /** 头像 */
  @ApiModelProperty(value = "头像")
  @TableField("face")
  private String face;

  /** 手机号 手机号 */
  @ApiModelProperty(value = "手机号 手机号")
  @TableField("mobile")
  private String mobile;

  /** 邮箱地址 邮箱地址 */
  @ApiModelProperty(value = "邮箱地址 邮箱地址")
  @TableField("email")
  private String email;

  /** 性别 性别 1:男  0:女  2:保密 */
  @ApiModelProperty(value = "性别 性别 1:男  0:女  2:保密")
  @TableField("sex")
  private Integer sex;

  /** 生日 生日 */
  @ApiModelProperty(value = "生日 生日")
  @TableField("birthday")
  private LocalDate birthday;

  /** 创建时间 创建时间 */
  @ApiModelProperty(value = "创建时间 创建时间")
  @TableField("created_time")
  private LocalDateTime createdTime;

  /** 更新时间 更新时间 */
  @ApiModelProperty(value = "更新时间 更新时间")
  @TableField("updated_time")
  private LocalDateTime updatedTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
