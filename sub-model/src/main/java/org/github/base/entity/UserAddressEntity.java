package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户地址表 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_address")
public class UserAddressEntity extends Model<UserAddressEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 地址主键id */
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 关联用户id */
  @TableField("user_id")
  private String userId;

  /** 收件人姓名 */
  @TableField("receiver")
  private String receiver;

  /** 收件人手机号 */
  @TableField("mobile")
  private String mobile;

  /** 省份 */
  @TableField("province")
  private String province;

  /** 城市 */
  @TableField("city")
  private String city;

  /** 区县 */
  @TableField("district")
  private String district;

  /** 详细地址 */
  @TableField("detail")
  private String detail;

  /** 扩展字段 */
  @TableField("extand")
  private String extand;

  /** 是否默认地址 */
  @TableField("is_default")
  private Integer isDefault;

  /** 创建时间 */
  @TableField("created_time")
  private LocalDateTime createdTime;

  /** 更新时间 */
  @TableField("updated_time")
  private LocalDateTime updatedTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
