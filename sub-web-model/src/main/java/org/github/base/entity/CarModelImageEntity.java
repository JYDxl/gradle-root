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
@TableName("car_model_image")
@ApiModel(value="CarModelImageEntity对象", description="")
public class CarModelImageEntity extends Model<CarModelImageEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("model_id")
  private @Nullable Integer modelId;

  @TableField("year")
  private @Nullable String year;

  @TableField("mod_default")
  private @Nullable Integer modDefault;

  @TableField("img_url")
  private @Nullable String imgUrl;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("update_time")
  private @Nullable Long updateTime;

  /** 仅当发布审核通过时才记录该时间 */
  @ApiModelProperty(value = "仅当发布审核通过时才记录该时间")
  @TableField("sync_time")
  private @Nullable Long syncTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
