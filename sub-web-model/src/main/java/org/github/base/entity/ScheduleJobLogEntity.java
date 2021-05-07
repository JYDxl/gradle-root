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
 * 定时任务日志
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("schedule_job_log")
@ApiModel(value="ScheduleJobLogEntity对象", description="定时任务日志")
public class ScheduleJobLogEntity extends Model<ScheduleJobLogEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 任务日志id */
  @ApiModelProperty(value = "任务日志id")
  @TableId(value = "log_id", type = IdType.AUTO)
  private @Nullable Long logId;

  /** 任务id */
  @ApiModelProperty(value = "任务id")
  @TableField("job_id")
  private @Nullable Long jobId;

  /** spring bean名称 */
  @ApiModelProperty(value = "spring bean名称")
  @TableField("bean_name")
  private @Nullable String beanName;

  /** 方法名 */
  @ApiModelProperty(value = "方法名")
  @TableField("method_name")
  private @Nullable String methodName;

  /** 参数 */
  @ApiModelProperty(value = "参数")
  @TableField("params")
  private @Nullable String params;

  /** 任务状态    0：成功    1：失败 */
  @ApiModelProperty(value = "任务状态    0：成功    1：失败")
  @TableField("status")
  private @Nullable Integer status;

  /** 失败信息 */
  @ApiModelProperty(value = "失败信息")
  @TableField("error")
  private @Nullable String error;

  /** 耗时(单位：毫秒) */
  @ApiModelProperty(value = "耗时(单位：毫秒)")
  @TableField("times")
  private @Nullable Integer times;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @Override
  protected Serializable pkVal() {
    return this.logId;
  }

}
