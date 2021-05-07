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
@TableName("activity_channel")
@ApiModel(value="ActivityChannelEntity对象", description="")
public class ActivityChannelEntity extends Model<ActivityChannelEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("name")
  private @Nullable String name;

  /** 0：未删除	            1：已删除 */
  @ApiModelProperty(value = "0：未删除	            1：已删除")
  @TableField("is_deleted")
  private @Nullable Integer isDeleted;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("last_update_time")
  private @Nullable Long lastUpdateTime;

  @TableField("use_count")
  private @Nullable String useCount;

  @TableField("sign")
  private @Nullable String sign;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
