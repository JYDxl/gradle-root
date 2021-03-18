package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 订单表;
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("orders")
public class OrdersEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 订单主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /** 商户订单号 */
    @TableField("merchant_order_id")
    private String merchantOrderId;

    /** 商户方的发起用户的用户主键id */
    @TableField("merchant_user_id")
    private String merchantUserId;

    /** 实际支付总金额（包含商户所支付的订单费邮费总额） */
    @TableField("amount")
    private Integer amount;

    /** 支付方式 */
    @TableField("pay_method")
    private Integer payMethod;

    /** 支付状态 10：未支付 20：已支付 30：支付失败 40：已退款 */
    @TableField("pay_status")
    private Integer payStatus;

    /** 从哪一端来的，比如从天天吃货这门实战过来的 */
    @TableField("come_from")
    private String comeFrom;

    /** 支付成功后的通知地址，这个是开发者那一段的，不是第三方支付通知的地址 */
    @TableField("return_url")
    private String returnUrl;

    /** 逻辑删除状态;1: 删除 0:未删除 */
    @TableField("is_delete")
    private Integer isDelete;

    /** 创建时间（成交时间） */
    @TableField("created_time")
    private LocalDateTime createdTime;
}
