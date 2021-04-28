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
@TableName("tb_users")
@ApiModel(value="TbUsersEntity对象", description="")
public class TbUsersEntity extends Model<TbUsersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.AUTO)
  private Integer userId;

  @TableField("user_name")
  private String userName;

  @TableField("password")
  private String password;

  @TableField("salt")
  private String salt;

  @TableField("phone")
  private String phone;

  @TableField("email")
  private String email;

  @TableField("status")
  private Integer status;

  @TableField("note")
  private String note;

  @TableField("create_time")
  private LocalDateTime createTime;

  @TableField("update_time")
  private LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.userId;
  }

}
