@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 码值条目
 *
 * @author JYD_XL
 */
@TableName("t_sys_dict_item")
open class SysDictItemEntity : Entity() {

    @TableField("dict_code")
    open var dictCode: String? = null

    @TableField("code")
    open var code: String? = null

    @TableField("name")
    open var name: String? = null

    @TableField("sort")
    open var sort: Int? = null

    @TableField("info")
    open var info: String? = null

    @TableField("revision")
    open var revision: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val DICT_CODE : String = "dict_code"

        const val CODE : String = "code"

        const val NAME : String = "name"

        const val SORT : String = "sort"

        const val INFO : String = "info"

        const val REVISION : String = "revision"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return "SysDictItemEntity{" +
        "dictCode=" + dictCode +
        ", code=" + code +
        ", name=" + name +
        ", sort=" + sort +
        ", info=" + info +
        ", revision=" + revision +
        "}"
    }

}
