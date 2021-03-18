package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 订单商品关联表 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("order_items")
public class OrderItemsEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 主键id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /** 归属订单id */
    @TableField("order_id")
    private String orderId;

    /** 商品id */
    @TableField("item_id")
    private String itemId;

    /** 商品图片 */
    @TableField("item_img")
    private String itemImg;

    /** 商品名称 */
    @TableField("item_name")
    private String itemName;

    /** 规格id */
    @TableField("item_spec_id")
    private String itemSpecId;

    /** 规格名称 */
    @TableField("item_spec_name")
    private String itemSpecName;

    /** 成交价格 */
    @TableField("price")
    private Integer price;

    /** 购买数量 */
    @TableField("buy_counts")
    private Integer buyCounts;
}
