package org.github.base.entity;

import org.github.base.Model;
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
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("member_profile")
@ApiModel(value="MemberProfileEntity对象", description="")
public class MemberProfileEntity extends Model<MemberProfileEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "member_id", type = IdType.ASSIGN_ID)
  private @Nullable Long memberId;

  @TableField("nickname")
  private @Nullable String nickname;

  @TableField("name")
  private @Nullable String name;

  /** 0：全部
            1：男
            2：女 */
  @ApiModelProperty(value = "0：全部
            1：男
            2：女")
  @TableField("gender")
  private @Nullable Integer gender;

  @TableField("level")
  private @Nullable Integer level;

  @TableField("avatar_url")
  private @Nullable String avatarUrl;

  @TableField("mobile_code")
  private @Nullable String mobileCode;

  @TableField("mobile")
  private @Nullable String mobile;

  @TableField("email")
  private @Nullable String email;

  @TableField("description")
  private @Nullable String description;

  @TableField("country")
  private @Nullable Integer country;

  @TableField("province")
  private @Nullable Integer province;

  @TableField("city")
  private @Nullable Integer city;

  @TableField("district")
  private @Nullable Integer district;

  @TableField("address")
  private @Nullable String address;

  @TableField("register_time")
  private @Nullable Long registerTime;

  @TableField("point")
  private @Nullable Integer point;

  @Override
  public Serializable pkVal() {
    return this.memberId;
  }

}
