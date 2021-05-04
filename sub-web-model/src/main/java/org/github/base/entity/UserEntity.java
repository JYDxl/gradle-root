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
@TableName("user")
@ApiModel(value="UserEntity对象", description="")
public class UserEntity extends Model<UserEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  @TableField("username")
  private @Nullable String username;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  @TableField("password")
  private @Nullable String password;

  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @TableField("salt")
  private @Nullable String salt;

  /** 是否启用（0：未启用 1：已启用） */
  @ApiModelProperty(value = "是否启用（0：未启用 1：已启用）")
  @TableField("enabled")
  private @Nullable Integer enabled;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
