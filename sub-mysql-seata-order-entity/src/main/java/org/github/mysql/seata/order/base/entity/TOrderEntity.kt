package org.github.mysql.seata.order.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 订单表
 *
 * @author JYD_XL
 */
@TableName("t_order")
@ApiModel(value = "TOrderEntity对象", description = "订单表")
open class TOrderEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    open var orderId: Long? = null

    /** 用户id */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    open var userId: Long? = null

    /** 产品id */
    @ApiModelProperty(value = "产品id")
    @TableField("product_id")
    open var productId: Long? = null

    /** 数量 */
    @ApiModelProperty(value = "数量")
    open var num: Int? = null

    /** 金额 */
    @ApiModelProperty(value = "金额")
    open var money: BigDecimal? = null

    /** 订单状态 0：创建中 1：已结束 */
    @ApiModelProperty(value = "订单状态 0：创建中 1：已结束")
    open var status: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ORDER_ID : String = "order_id"

        const val USER_ID : String = "user_id"

        const val PRODUCT_ID : String = "product_id"

        const val NUM : String = "num"

        const val MONEY : String = "money"

        const val STATUS : String = "status"

    }

    override fun pkVal(): java.io.Serializable? {
        return orderId
    }

    override fun toString(): String {
        return "TOrderEntity{" +
        "orderId=" + orderId +
        ", userId=" + userId +
        ", productId=" + productId +
        ", num=" + num +
        ", money=" + money +
        ", status=" + status +
        "}"
    }

}
