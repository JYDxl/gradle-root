package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单商品关联表 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("order_items")
@ApiModel(value="OrderItemsEntity对象", description="订单商品关联表 ")
public class OrderItemsEntity extends Model<OrderItemsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 主键id */
  @ApiModelProperty(value = "主键id")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 归属订单id */
  @ApiModelProperty(value = "归属订单id")
  @TableField("order_id")
  private String orderId;

  /** 商品id */
  @ApiModelProperty(value = "商品id")
  @TableField("item_id")
  private String itemId;

  /** 商品图片 */
  @ApiModelProperty(value = "商品图片")
  @TableField("item_img")
  private String itemImg;

  /** 商品名称 */
  @ApiModelProperty(value = "商品名称")
  @TableField("item_name")
  private String itemName;

  /** 规格id */
  @ApiModelProperty(value = "规格id")
  @TableField("item_spec_id")
  private String itemSpecId;

  /** 规格名称 */
  @ApiModelProperty(value = "规格名称")
  @TableField("item_spec_name")
  private String itemSpecName;

  /** 成交价格 */
  @ApiModelProperty(value = "成交价格")
  @TableField("price")
  private Integer price;

  /** 购买数量 */
  @ApiModelProperty(value = "购买数量")
  @TableField("buy_counts")
  private Integer buyCounts;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
