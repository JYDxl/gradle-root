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
@TableName("member_token")
@ApiModel(value="MemberTokenEntity对象", description="")
public class MemberTokenEntity extends Model<MemberTokenEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "member_id", type = IdType.ASSIGN_ID)
  private @Nullable Long memberId;

  @TableField("token")
  private @Nullable String token;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("duration")
  private @Nullable Long duration;

  @TableField("expired_time")
  private @Nullable Long expiredTime;

  @Override
  public Serializable pkVal() {
    return this.memberId;
  }

}
