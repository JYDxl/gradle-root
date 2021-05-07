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
 * 系统日志
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_log")
@ApiModel(value="SysLogEntity对象", description="系统日志")
public class SysLogEntity extends Model<SysLogEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  @TableField("username")
  private @Nullable String username;

  /** 用户操作 */
  @ApiModelProperty(value = "用户操作")
  @TableField("operation")
  private @Nullable String operation;

  /** 请求方法 */
  @ApiModelProperty(value = "请求方法")
  @TableField("method")
  private @Nullable String method;

  /** 请求参数 */
  @ApiModelProperty(value = "请求参数")
  @TableField("params")
  private @Nullable String params;

  /** IP地址 */
  @ApiModelProperty(value = "IP地址")
  @TableField("ip")
  private @Nullable String ip;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_date")
  private @Nullable LocalDateTime createDate;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
