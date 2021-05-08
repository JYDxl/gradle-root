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
@TableName("message_sendlog")
@ApiModel(value="MessageSendlogEntity对象", description="")
public class MessageSendlogEntity extends Model<MessageSendlogEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("message_id")
  private @Nullable Long messageId;

  @TableField("send_time")
  private @Nullable Long sendTime;

  @TableField("to_mid")
  private @Nullable Long toMid;

  /** 0：未接收	            1：已接收 */
  @ApiModelProperty(value = "0：未接收	            1：已接收")
  @TableField("received")
  private @Nullable Integer received;

  @TableField("receive_time")
  private @Nullable Long receiveTime;

  /** 0：未阅读	            1：已阅读 */
  @ApiModelProperty(value = "0：未阅读	            1：已阅读")
  @TableField("viewed")
  private @Nullable Integer viewed;

  @TableField("view_time")
  private @Nullable Long viewTime;

  @TableField("view_detail")
  private @Nullable Integer viewDetail;

  @TableField("view_detail_time")
  private @Nullable Long viewDetailTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
