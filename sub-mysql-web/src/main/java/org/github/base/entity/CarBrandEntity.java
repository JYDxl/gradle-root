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
@TableName("car_brand")
@ApiModel(value="CarBrandEntity对象", description="")
public class CarBrandEntity extends Model<CarBrandEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("name")
  private @Nullable String name;

  /** 0：未启用
            1：已启用 */
  @ApiModelProperty(value = "0：未启用
            1：已启用")
  @TableField("other_name")
  private @Nullable String otherName;

  @TableField("english_name")
  private @Nullable String englishName;

  @TableField("country_id")
  private @Nullable Integer countryId;

  @TableField("logo_url")
  private @Nullable String logoUrl;

  /** 此字段为冗余字段，存放逗号分割的标签ID，用于便捷的进行资讯的筛选等操作，真正的资讯和标签的关联关系存放在article_tag表中 */
  @ApiModelProperty(value = "此字段为冗余字段，存放逗号分割的标签ID，用于便捷的进行资讯的筛选等操作，真正的资讯和标签的关联关系存放在article_tag表中")
  @TableField("logo_meaning")
  private @Nullable String logoMeaning;

  @TableField("first_char")
  private @Nullable String firstChar;

  @TableField("spell")
  private @Nullable String spell;

  @TableField("all_spell")
  private @Nullable String allSpell;

  @TableField("name_spell")
  private @Nullable String nameSpell;

  @TableField("name_all_spell")
  private @Nullable String nameAllSpell;

  @TableField("introduction")
  private @Nullable String introduction;

  @TableField("sale_status")
  private @Nullable Integer saleStatus;

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

  /** 0：草稿；
            1：等待内容审核；
            2：内容审核通过；
            3：内容审核退回； */
  @ApiModelProperty(value = "0：草稿；
            1：等待内容审核；
            2：内容审核通过；
            3：内容审核退回；")
  @TableField("do_time")
  private @Nullable Long doTime;

  /** 仅当发布审核通过时才记录该时间 */
  @ApiModelProperty(value = "仅当发布审核通过时才记录该时间")
  @TableField("sync_time")
  private @Nullable Long syncTime;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
