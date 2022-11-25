@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 码值类型
 *
 * @author JYD_XL
 */
@TableName("t_sys_dict")
open class SysDictEntity : Entity() {

    @TableField("code")
    open var code: String? = null

    @TableField("name")
    open var name: String? = null

    @TableField("info")
    open var info: String? = null

    @TableField("revision")
    open var revision: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val CODE : String = "code"

        const val NAME : String = "name"

        const val INFO : String = "info"

        const val REVISION : String = "revision"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return "SysDictEntity{" +
        "code=" + code +
        ", name=" + name +
        ", info=" + info +
        ", revision=" + revision +
        "}"
    }

}
