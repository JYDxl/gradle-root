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
@TableName("car_make")
@ApiModel(value="CarMakeEntity对象", description="")
public class CarMakeEntity extends Model<CarMakeEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("brand_id")
  private @Nullable Integer brandId;

  @TableField("brand_name")
  private @Nullable String brandName;

  @TableField("name")
  private @Nullable String name;

  /** 0：未启用	            1：已启用 */
  @ApiModelProperty(value = "0：未启用	            1：已启用")
  @TableField("other_name")
  private @Nullable String otherName;

  @TableField("english_name")
  private @Nullable String englishName;

  @TableField("manufacturer_id")
  private @Nullable Integer manufacturerId;

  @TableField("country_id")
  private @Nullable Integer countryId;

  @TableField("phone")
  private @Nullable String phone;

  @TableField("website")
  private @Nullable String website;

  @TableField("logo_url")
  private @Nullable String logoUrl;

  @TableField("spell")
  private @Nullable String spell;

  @TableField("introduction")
  private @Nullable String introduction;

  @TableField("is_enabled")
  private @Nullable Integer isEnabled;

  /** 如果是外部资源，那么该字段值为0 */
  @ApiModelProperty(value = "如果是外部资源，那么该字段值为0")
  @TableField("is_removed")
  private @Nullable Integer isRemoved;

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
