package org.github.base.entity;

import org.github.base.Model;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("items_spec")
@ApiModel(value="ItemsSpecEntity对象", description="商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计")
public class ItemsSpecEntity extends Model<ItemsSpecEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 商品规格id */
  @ApiModelProperty(value = "商品规格id")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 商品外键id */
  @ApiModelProperty(value = "商品外键id")
  @TableField("item_id")
  private String itemId;

  /** 规格名称 */
  @ApiModelProperty(value = "规格名称")
  @TableField("name")
  private String name;

  /** 库存 */
  @ApiModelProperty(value = "库存")
  @TableField("stock")
  private Integer stock;

  /** 折扣力度 */
  @ApiModelProperty(value = "折扣力度")
  @TableField("discounts")
  private BigDecimal discounts;

  /** 优惠价 */
  @ApiModelProperty(value = "优惠价")
  @TableField("price_discount")
  private Integer priceDiscount;

  /** 原价 */
  @ApiModelProperty(value = "原价")
  @TableField("price_normal")
  private Integer priceNormal;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("created_time")
  private LocalDateTime createdTime;

  /** 更新时间 */
  @ApiModelProperty(value = "更新时间")
  @TableField("updated_time")
  private LocalDateTime updatedTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
