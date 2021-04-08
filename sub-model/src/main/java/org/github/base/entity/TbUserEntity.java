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
 * 用户信息表
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_user")
@ApiModel(value="TbUserEntity对象", description="用户信息表")
public class TbUserEntity extends Model<TbUserEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 主键ID */
  @ApiModelProperty(value = "主键ID")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  @TableField("user_name")
  private String userName;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  @TableField("password")
  private String password;

  /** 姓名 */
  @ApiModelProperty(value = "姓名")
  @TableField("name")
  private String name;

  /** 年龄 */
  @ApiModelProperty(value = "年龄")
  @TableField("age")
  private Integer age;

  /** 邮箱 */
  @ApiModelProperty(value = "邮箱")
  @TableField("email")
  private String email;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
