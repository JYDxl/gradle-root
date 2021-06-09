@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 支付表
 *
 * @author JYD_XL
 */
@TableName("payment")
@ApiModel(value = "PaymentEntity对象", description = "支付表")
open class PaymentEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 序列号 */
    @ApiModelProperty(value = "序列号")
    open var serial: String? = null

    override fun toString(): String {
        return "PaymentEntity{" +
        "id=" + id +
        ", serial=" + serial +
        "}"
    }

}
