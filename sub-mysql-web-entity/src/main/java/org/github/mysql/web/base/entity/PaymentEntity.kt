@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.*
import org.github.base.IEntity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 支付表
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@TableName("payment")
@ApiModel(value="PaymentEntity对象", description="支付表")
open class PaymentEntity : IEntity() {

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    @ApiModelProperty(value = "serial")
    @TableField("serial")
    open var serial: String? = null

    override fun toString(): String {
        return "PaymentEntity{" +
        "id=" + id +
        ", serial=" + serial +
        "}"
    }
}
