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
@TableName("visit_log")
@ApiModel(value="VisitLogEntity对象", description="")
public class VisitLogEntity extends Model<VisitLogEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("visitor_id")
  private @Nullable Long visitorId;

  @TableField("member_id")
  private @Nullable Long memberId;

  @TableField("visit_url")
  private @Nullable String visitUrl;

  /** 0：不是首次登录	            1：是首次登录 */
  @ApiModelProperty(value = "0：不是首次登录	            1：是首次登录")
  @TableField("visit_ip")
  private @Nullable String visitIp;

  @TableField("visit_device")
  private @Nullable String visitDevice;

  @TableField("visit_source")
  private @Nullable String visitSource;

  @TableField("enter_time")
  private @Nullable Long enterTime;

  @TableField("exit_time")
  private @Nullable Long exitTime;

  @TableField("stay")
  private @Nullable Long stay;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
