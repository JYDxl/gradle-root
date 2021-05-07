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
@TableName("activity_key")
@ApiModel(value="ActivityKeyEntity对象", description="")
public class ActivityKeyEntity extends Model<ActivityKeyEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("activity_id")
  private @Nullable Integer activityId;

  /** 对应car_model表的id字段 */
  @ApiModelProperty(value = "对应car_model表的id字段")
  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("act_key")
  private @Nullable String actKey;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
