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
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_job_details")
@ApiModel(value="QrtzJobDetailsEntity对象", description="")
public class QrtzJobDetailsEntity extends Model<QrtzJobDetailsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("JOB_NAME")
  private @Nullable String jobName;

  @TableField("JOB_GROUP")
  private @Nullable String jobGroup;

  @TableField("DESCRIPTION")
  private @Nullable String description;

  @TableField("JOB_CLASS_NAME")
  private @Nullable String jobClassName;

  @TableField("IS_DURABLE")
  private @Nullable String isDurable;

  @TableField("IS_NONCONCURRENT")
  private @Nullable String isNonconcurrent;

  @TableField("IS_UPDATE_DATA")
  private @Nullable String isUpdateData;

  @TableField("REQUESTS_RECOVERY")
  private @Nullable String requestsRecovery;

  @TableField("JOB_DATA")
  private @Nullable Blob jobData;

  @Override
  public Serializable pkVal() {
    return this.schedName;
  }

}
