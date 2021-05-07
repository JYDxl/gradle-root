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
 * 用户Token
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_token")
@ApiModel(value="TbTokenEntity对象", description="用户Token")
public class TbTokenEntity extends Model<TbTokenEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.ASSIGN_ID)
  private @Nullable Long userId;

  /** token */
  @ApiModelProperty(value = "token")
  @TableField("token")
  private @Nullable String token;

  /** 过期时间 */
  @ApiModelProperty(value = "过期时间")
  @TableField("expire_time")
  private @Nullable LocalDateTime expireTime;

  /** 更新时间 */
  @ApiModelProperty(value = "更新时间")
  @TableField("update_time")
  private @Nullable LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.userId;
  }

}
