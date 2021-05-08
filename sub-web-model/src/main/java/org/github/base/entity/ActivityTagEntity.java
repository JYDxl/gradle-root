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
@TableName("activity_tag")
@ApiModel(value="ActivityTagEntity对象", description="")
public class ActivityTagEntity extends Model<ActivityTagEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("activity_id")
  private @Nullable Long activityId;

  /** 对应car_model表的id字段 */
  @ApiModelProperty(value = "对应car_model表的id字段")
  @TableField("tag_id")
  private @Nullable Long tagId;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
