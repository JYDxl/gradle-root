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
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("member_login_log")
@ApiModel(value="MemberLoginLogEntity对象", description="")
public class MemberLoginLogEntity extends Model<MemberLoginLogEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("member_id")
  private @Nullable Long memberId;

  @TableField("login_time")
  private @Nullable Long loginTime;

  /** 0：不是首次登录	            1：是首次登录 */
  @ApiModelProperty(value = "0：不是首次登录	            1：是首次登录")
  @TableField("is_first")
  private @Nullable Integer isFirst;

  @TableField("login_ip")
  private @Nullable String loginIp;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
