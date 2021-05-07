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
@TableName("message")
@ApiModel(value="MessageEntity对象", description="")
public class MessageEntity extends Model<MessageEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("content")
  private @Nullable String content;

  @TableField("type")
  private @Nullable Integer type;

  @TableField("link")
  private @Nullable String link;

  /** 0：立即发送	            1：定时发送 */
  @ApiModelProperty(value = "0：立即发送	            1：定时发送")
  @TableField("is_schedule")
  private @Nullable Integer isSchedule;

  @TableField("schedule_time")
  private @Nullable Long scheduleTime;

  @TableField("send_time")
  private @Nullable Long sendTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
