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
 * 定时任务
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("schedule_job")
@ApiModel(value="ScheduleJobEntity对象", description="定时任务")
public class ScheduleJobEntity extends Model<ScheduleJobEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 任务id */
  @ApiModelProperty(value = "任务id")
  @TableId(value = "job_id", type = IdType.AUTO)
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

  /** cron表达式 */
  @ApiModelProperty(value = "cron表达式")
  @TableField("cron_expression")
  private @Nullable String cronExpression;

  /** 任务状态 */
  @ApiModelProperty(value = "任务状态")
  @TableField("status")
  private @Nullable Integer status;

  /** 备注 */
  @ApiModelProperty(value = "备注")
  @TableField("remark")
  private @Nullable String remark;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private @Nullable LocalDateTime createTime;

  @Override
  public Serializable pkVal() {
    return this.jobId;
  }

}
