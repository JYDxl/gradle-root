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
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("visitor")
@ApiModel(value="VisitorEntity对象", description="")
public class VisitorEntity extends Model<VisitorEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("visitor_guid")
  private @Nullable String visitorGuid;

  @TableField("first_visit_time")
  private @Nullable Long firstVisitTime;

  /** 0：不是首次登录
            1：是首次登录 */
  @ApiModelProperty(value = "0：不是首次登录
            1：是首次登录")
  @TableField("entry_url")
  private @Nullable String entryUrl;

  @TableField("visitor_ip")
  private @Nullable String visitorIp;

  @TableField("visitor_device")
  private @Nullable String visitorDevice;

  @TableField("visitor_channel")
  private @Nullable String visitorChannel;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
