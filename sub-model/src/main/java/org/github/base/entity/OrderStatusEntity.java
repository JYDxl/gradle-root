package org.github.base.entity;

import org.github.base.Model;
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
 * 订单状态表;订单的每个状态更改都需要进行记录
10：待付款  20：已付款，待发货  30：已发货，待收货（7天自动确认）  40：交易成功（此时可以评价）50：交易关闭（待付款时，用户取消 或 长时间未付款，系统识别后自动关闭）
退货/退货，此分支流程不做，所以不加入
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("order_status")
@ApiModel(value="OrderStatusEntity对象", description="订单状态表;订单的每个状态更改都需要进行记录")
public class OrderStatusEntity extends Model<OrderStatusEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 订单ID;对应订单表的主键id */
  @ApiModelProperty(value = "订单ID;对应订单表的主键id")
  @TableId(value = "order_id", type = IdType.ASSIGN_ID)
  private String orderId;

  /** 订单状态 */
  @ApiModelProperty(value = "订单状态")
  @TableField("order_status")
  private Integer orderStatus;

  /** 订单创建时间;对应[10:待付款]状态 */
  @ApiModelProperty(value = "订单创建时间;对应[10:待付款]状态")
  @TableField("created_time")
  private LocalDateTime createdTime;

  /** 支付成功时间;对应[20:已付款，待发货]状态 */
  @ApiModelProperty(value = "支付成功时间;对应[20:已付款，待发货]状态")
  @TableField("pay_time")
  private LocalDateTime payTime;

  /** 发货时间;对应[30：已发货，待收货]状态 */
  @ApiModelProperty(value = "发货时间;对应[30：已发货，待收货]状态")
  @TableField("deliver_time")
  private LocalDateTime deliverTime;

  /** 交易成功时间;对应[40：交易成功]状态 */
  @ApiModelProperty(value = "交易成功时间;对应[40：交易成功]状态")
  @TableField("success_time")
  private LocalDateTime successTime;

  /** 交易关闭时间;对应[50：交易关闭]状态 */
  @ApiModelProperty(value = "交易关闭时间;对应[50：交易关闭]状态")
  @TableField("close_time")
  private LocalDateTime closeTime;

  /** 留言时间;用户在交易成功后的留言时间 */
  @ApiModelProperty(value = "留言时间;用户在交易成功后的留言时间")
  @TableField("comment_time")
  private LocalDateTime commentTime;

  @Override
  protected Serializable pkVal() {
    return this.orderId;
  }

}