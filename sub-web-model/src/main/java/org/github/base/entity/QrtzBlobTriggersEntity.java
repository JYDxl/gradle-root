package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.*;
import java.sql.Blob;
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
@TableName("qrtz_blob_triggers")
@ApiModel(value="QrtzBlobTriggersEntity对象", description="")
public class QrtzBlobTriggersEntity extends Model<QrtzBlobTriggersEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("TRIGGER_NAME")
  private @Nullable String triggerName;

  @TableField("TRIGGER_GROUP")
  private @Nullable String triggerGroup;

  @TableField("BLOB_DATA")
  private @Nullable Blob blobData;

  @Override
  protected Serializable pkVal() {
    return this.schedName;
  }

}
