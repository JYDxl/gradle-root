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
 * 用户
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_user")
@ApiModel(value="TbUserEntity对象", description="用户")
public class TbUserEntity extends Model<TbUserEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.AUTO)
  private @Nullable Long userId;

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  @TableField("username")
  private @Nullable String username;

  /** 手机号 */
  @ApiModelProperty(value = "手机号")
  @TableField("mobile")
  private @Nullable String mobile;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  @TableField("password")
  private @Nullable String password;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @Override
  protected Serializable pkVal() {
    return this.userId;
  }

}
