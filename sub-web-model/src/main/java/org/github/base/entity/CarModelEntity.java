package org.github.base.entity;

import org.github.base.Model;
import java.math.BigDecimal;
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
@TableName("car_model")
@ApiModel(value="CarModelEntity对象", description="")
public class CarModelEntity extends Model<CarModelEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("brand_id")
  private @Nullable Integer brandId;

  @TableField("brand_name")
  private @Nullable String brandName;

  @TableField("make_id")
  private @Nullable Integer makeId;

  @TableField("make_name")
  private @Nullable String makeName;

  @TableField("name")
  private @Nullable String name;

  @TableField("display_name")
  private @Nullable String displayName;

  /** 0：未启用	            1：已启用 */
  @ApiModelProperty(value = "0：未启用	            1：已启用")
  @TableField("other_name")
  private @Nullable String otherName;

  @TableField("english_name")
  private @Nullable String englishName;

  @TableField("country_class")
  private @Nullable Integer countryClass;

  @TableField("country_class_name")
  private @Nullable String countryClassName;

  /** 类似：SUV、MPV等 */
  @ApiModelProperty(value = "类似：SUV、MPV等")
  @TableField("body_form")
  private @Nullable Integer bodyForm;

  @TableField("body_form_name")
  private @Nullable String bodyFormName;

  @TableField("price_low")
  private @Nullable BigDecimal priceLow;

  @TableField("price_high")
  private @Nullable BigDecimal priceHigh;

  /** 0：其它	            1：微型车	            2：小型车	            3：紧凑型车	            4：中型车	            5：中大型车	            6：豪华车	            7：SUV	            8：MPV	            9：跑车	            10：概念车	            11：面包车	            12：皮卡	            13：轻客	            14：客车	            15：卡车	            16：轻卡	            17：重卡 */
  @ApiModelProperty(value = "0：其它	            1：微型车	            2：小型车	            3：紧凑型车	            4：中型车	            5：中大型车	            6：豪华车	            7：SUV	            8：MPV	            9：跑车	            10：概念车	            11：面包车	            12：皮卡	            13：轻客	            14：客车	            15：卡车	            16：轻卡	            17：重卡")
  @TableField("level")
  private @Nullable Integer level;

  @TableField("level_name")
  private @Nullable String levelName;

  /** 0：其它	            1：小型suv	            2：紧凑型suv	            3：中型suv	            4：中大型suv	            5：大型suv	            6：微客	            7：小客	            8：中客	            9：大客	            10：微卡	            11：轻卡	            12：中卡	            13：重卡 */
  @ApiModelProperty(value = "0：其它	            1：小型suv	            2：紧凑型suv	            3：中型suv	            4：中大型suv	            5：大型suv	            6：微客	            7：小客	            8：中客	            9：大客	            10：微卡	            11：轻卡	            12：中卡	            13：重卡")
  @TableField("level_second")
  private @Nullable Integer levelSecond;

  @TableField("level_second_name")
  private @Nullable String levelSecondName;

  @TableField("sale_status")
  private @Nullable Integer saleStatus;

  @TableField("all_spell")
  private @Nullable String allSpell;

  @TableField("country_id")
  private @Nullable Integer countryId;

  @TableField("country_name")
  private @Nullable String countryName;

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
