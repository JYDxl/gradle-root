@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 支付表
 *
 * @author JYD_XL
 */
@TableName("payment")
open class PaymentEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 序列号 */
    @TableField("serial")
    open var serial: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val SERIAL : String = "serial"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "PaymentEntity{" +
        "id=" + id +
        ", serial=" + serial +
        "}"
    }

}
