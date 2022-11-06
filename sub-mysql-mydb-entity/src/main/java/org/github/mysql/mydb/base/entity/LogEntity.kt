@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("log")
open class LogEntity : Entity() {

    @TableField("info")
    open var info: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val INFO : String = "info"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return "LogEntity{" +
        "info=" + info +
        "}"
    }

}
