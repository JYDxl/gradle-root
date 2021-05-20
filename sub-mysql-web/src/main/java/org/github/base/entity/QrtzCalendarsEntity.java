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
@TableName("qrtz_calendars")
@ApiModel(value="QrtzCalendarsEntity对象", description="")
public class QrtzCalendarsEntity extends Model<QrtzCalendarsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
  private @Nullable String schedName;

  @TableField("CALENDAR_NAME")
  private @Nullable String calendarName;

  @TableField("CALENDAR")
  private @Nullable Blob calendar;

  @Override
  public Serializable pkVal() {
    return this.schedName;
  }

}
