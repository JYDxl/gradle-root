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
@TableName("user")
@ApiModel(value="UserEntity对象", description="")
public class UserEntity extends Model<UserEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  @TableField("username")
  private String username;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  @TableField("password")
  private String password;

  @TableField("create_time")
  private LocalDateTime createTime;

  @TableField("salt")
  private String salt;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
