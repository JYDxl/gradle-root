@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.Version
import java.io.Serializable
import org.github.core.base.Entity

/**
 * 码值条目
 *
 * @author JYD_XL
 */
@TableName("t_sys_dict_item")
open class SysDictItemMbpEntity : Entity() {

    @TableField("dict_code")
    open var dictCode: String? = null

    @TableField("item_code")
    open var itemCode: String? = null

    @TableField("item_name")
    open var itemName: String? = null

    @TableField("item_info")
    open var itemInfo: String? = null

    @TableField("sort")
    open var sort: Int? = null

    @TableField("revision")
    @Version
    open var revision: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val DICT_CODE : String = "dict_code"

        const val ITEM_CODE : String = "item_code"

        const val ITEM_NAME : String = "item_name"

        const val ITEM_INFO : String = "item_info"

        const val SORT : String = "sort"

        const val REVISION : String = "revision"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return get()
    }

}
