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
 * @since 2021-05-08
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("activity_link")
@ApiModel(value="ActivityLinkEntity对象", description="")
public class ActivityLinkEntity extends Model<ActivityLinkEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  @TableField("channel_id")
  private @Nullable Integer channelId;

  @TableField("link")
  private @Nullable String link;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
