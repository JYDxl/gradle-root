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
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-05
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_users")
@ApiModel(value="TbUsersEntity对象", description="")
public class TbUsersEntity extends Model<TbUsersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.AUTO)
  private @Nullable Integer userId;

  @TableField("user_name")
  private @Nullable String userName;

  @TableField("password")
  private @Nullable String password;

  @TableField("salt")
  private @Nullable String salt;

  @TableField("phone")
  private @Nullable String phone;

  @TableField("email")
  private @Nullable String email;

  @TableField("status")
  private @Nullable Integer status;

  @TableField("note")
  private @Nullable String note;

  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @TableField("update_time")
  private @Nullable LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.userId;
  }

}
